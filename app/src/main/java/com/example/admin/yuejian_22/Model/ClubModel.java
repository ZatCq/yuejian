package com.example.admin.yuejian_22.Model;

import com.example.admin.yuejian_22.Bean.ClubList;
import com.example.admin.yuejian_22.Interf.ClubListInterf;
import com.example.admin.yuejian_22.Interf.RetrofitService;
import com.example.admin.yuejian_22.Listener.ClubDListListener;
import com.example.admin.yuejian_22.Listener.ClubListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 2017/9/29.
 */
public class ClubModel implements ClubListInterf{

//public class ClubModel  implements ClubList{

       private RetrofitService retrofitService;
  private static final String BASE_URL = "http://172.24.10.175/workout/api.php/";
        private Retrofit retrofit;
    private ClubListInterf clubListInterf;

        public ClubModel() {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

    @Override
    public void getAllClub(String id, String club_name, final ClubListener clubListener) {
        retrofitService = retrofit.create(RetrofitService.class);
        Call<List<ClubList>> call =retrofitService.getAllClub();
        call.enqueue(new Callback<List<ClubList>>() {
            @Override
            public void onResponse(Call<List<ClubList>> call, Response<List<ClubList>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    clubListener.onResponse(response.body());
                } else {
                    clubListener.onFail("onresponse fail");
                }
            }

            @Override
            public void onFailure(Call<List<ClubList>> call, Throwable t) {
                clubListener.onFail(t.toString());
            }
        });
    }


    @Override
    public void getNearClub(String id, String club_name, final ClubDListListener clubDListListener) {
        retrofitService = retrofit.create(RetrofitService.class);
        Call<List<ClubList>> call =retrofitService.getNearClub();
        call.enqueue(new Callback<List<ClubList>>() {
            @Override
            public void onResponse(Call<List<ClubList>> call, Response<List<ClubList>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    clubDListListener.onResponse(response.body());
                } else {
                    clubDListListener.onFail("onresponse fail");
                }
            }

            @Override
            public void onFailure(Call<List<ClubList>> call, Throwable t) {
                clubDListListener.onFail(t.toString());
            }
        });
    }

}


