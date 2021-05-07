package com.example.admin.yuejian_22.Model;

import com.example.admin.yuejian_22.Bean.ArticleBean;
import com.example.admin.yuejian_22.Interf.ArticleService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Admin on 2017/9/29.
 */

public class ArticleModel implements ArticleService{

    @Override
    public Call<List<ArticleBean>> getResultList(@Path("mod") String mod, @Query("page") int page, @Header("SessionID") String sessionId) {
        return null;
    }
}
