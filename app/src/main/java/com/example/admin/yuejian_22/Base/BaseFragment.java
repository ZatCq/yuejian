package com.example.admin.yuejian_22.Base;

import android.support.v4.app.Fragment;

/**
 * Created by Admin on 2017/9/25.
 */

public abstract class BaseFragment extends Fragment {
    public String getUserId(){

        String userId = BaseActivity.getUserId();
        return userId;


    }
    public void setUserId(String userId){
        BaseActivity.setUserId(userId);
    }

}
