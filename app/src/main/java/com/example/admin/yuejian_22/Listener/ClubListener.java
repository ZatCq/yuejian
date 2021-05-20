package com.example.admin.yuejian_22.Listener;


import com.example.admin.yuejian_22.Bean.ClubList;
import java.util.List;

/**
 * Created by Admin on 2017/10/10.
 */

public interface ClubListener {


        public void onResponse(List<ClubList> clubListList);
        public void onFail(String msg);
    }





