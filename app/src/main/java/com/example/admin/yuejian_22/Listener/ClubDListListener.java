package com.example.admin.yuejian_22.Listener;

import com.example.admin.yuejian_22.Bean.ClubList;

import java.util.List;

/**
 * Created by Admin on 2017/10/11.
 */

public interface ClubDListListener {
    public void onResponse(List<ClubList> clubLists);
    public void onFail(String msg);
}
