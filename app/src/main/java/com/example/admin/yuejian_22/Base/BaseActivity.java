package com.example.admin.yuejian_22.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Admin on 2017/9/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected static String userId;

    public abstract View onViewCreated(View view, @Nullable Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public static void setUserId(String uid){
        userId = uid;
    }

    public static String getUserId(){
        return userId;
    }
}
