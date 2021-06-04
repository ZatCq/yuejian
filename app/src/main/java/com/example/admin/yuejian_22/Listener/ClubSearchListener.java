package com.example.admin.yuejian_22.Listener;

import com.example.admin.yuejian_22.Bean.ClubList;

import java.util.List;

/**
 * Created by Admin on 2017/10/11.
 */

public interface ClubSearchListener {
    public void onResponse(List<ClubList> clubListsearch);
    public void onFail(String msg);
}
