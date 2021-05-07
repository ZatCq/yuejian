package com.example.admin.yuejian_22.Interf;

import com.example.admin.yuejian_22.Bean.ArticleBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Admin on 2017/9/29.
 */

public interface ArticleService {
    @GET("api.php/lists/mod/{mod}")
    Call<List<ArticleBean>>getResultList(@Path("mod") String mod,
                                     @Query("page" )int page,
                                     @Header("SessionID") String sessionId);
}
