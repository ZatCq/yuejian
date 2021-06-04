package com.example.admin.yuejian_22.Interf;

import com.example.admin.yuejian_22.Listener.ClubDListListener;
import com.example.admin.yuejian_22.Listener.ClubListener;
import com.example.admin.yuejian_22.Listener.ClubSearchListener;

/**
 * Created by Admin on 2017/10/10.
 */

public interface ClubListInterf {


    void getAllClub(String id, String club_name, ClubListener clubListener);
        void getNearClub(String id, String club_name, ClubDListListener clubDListListener);
    void getSearchClub(String id, String club_name, ClubSearchListener clubSearchListener);

}


