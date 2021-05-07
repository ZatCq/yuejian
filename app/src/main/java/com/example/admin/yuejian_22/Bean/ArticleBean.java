package com.example.admin.yuejian_22.Bean;

/**
 * Created by Admin on 2017/9/29.
 */

public class ArticleBean {
//    "mod") String mod,
//    @Query("page" )int page,
//    @Header("SessionID") String sessionId)
    private String mod;
    private int page;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private String sessionId;
}
