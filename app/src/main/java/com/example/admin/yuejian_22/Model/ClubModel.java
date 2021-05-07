package com.example.admin.yuejian_22.Model;

import com.example.admin.yuejian_22.Interf.ClubList;
import com.example.admin.yuejian_22.Interf.RetrofitService;
import com.example.admin.yuejian_22.Listener.ClubListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.admin.yuejian_22.Model.Service.BASE_URL;

/**
 * Created by Admin on 2017/9/29.
 */
public class ClubModel {

//public class ClubModel  implements ClubList{

       private RetrofitService retrofitService;
  private static final String BASE_URL = "http://172.24.10.175/workout/api.php/";
        private Retrofit retrofit;

        public ClubModel() {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    public void getAllClub(String id, String club_name, final ClubListener clubListener){
        retrofitService = retrofit.create(RetrofitService.class);
//        Call<List<ClubList>> call = retrofitService
//                .getAllClub(id,club_name);
    }

//        public Call getAllClub() {
//            RetrofitService retrofitService = Retrofit.create(RetrofitService.class);
//            return retrofitService.getAllClub();
//        }
//
//        public Call getNearClub() {
//            RetrofitService retrofitService = Retrofit.create(RetrofitService.class);
//            return retrofitService.getNearClub();
//        }




}


//    @Override
//    public void getList(String id, String club_name,final ClubListener listListener) {
//        clubService = retrofit.create(ClubService.class);
//        Call<List<ClubBean>> call =clubService.getClubList(id,club_name);
//        call.enqueue(new Callback<List<ClubBean>>() {
//            @Override
//            public void onResponse(Call<List<ClubBean>> call, Response<List<ClubBean>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    listListener.onResponse(response.body());
//                } else {
//                    listListener.onFail("onresponse fail");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ClubBean>> call, Throwable t) {
//                listListener.onFail(t.toString());
//            }
//        });
//    }
//
//
//}

