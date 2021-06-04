package com.example.admin.yuejian_22.Interf;

import com.example.admin.yuejian_22.Bean.ClubList;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 2017/9/25.
 */

public interface  RetrofitService {

//    http://172.24.10.175/workout/api.php/getmine/SessionID/060pn7sjorpnq5fp53kid5st54/userid/19/

    @GET("lists/mod/club")
    Call<List<ClubList>> getAllClub(

    );
    @GET("nearclub")
    Call<List<ClubList>> getNearClub(
    );
    @GET("lists/mod/club")
    Call<List<ClubList>> getSearchClub(
            @Query("search") String club_name
    );


}
