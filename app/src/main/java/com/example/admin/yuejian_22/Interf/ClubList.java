package com.example.admin.yuejian_22.Interf;

import com.example.admin.yuejian_22.Listener.ClubListener;

/**
 * Created by Admin on 2017/10/10.
 */

public interface ClubList {




    /**
     * Created by wangmengmeng on 2017/9/30.
     */

    public interface ClubFace {
        void getAllClub(String id, String club_name, ClubListener clubListener);
        void getNearClub(String id, String club_name, ClubListener clubListener);
    }

}
