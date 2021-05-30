package com.example.admin.yuejian_22;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.admin.yuejian_22.Base.BaseActivity;
import com.example.admin.yuejian_22.Fragment.LoginFragment;
import com.example.admin.yuejian_22.Fragment.MainFragment;

public class MainActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private LoginFragment loginFragment;
    private MainFragment mainFragment;
    private SharedPreferences preferences;
    private final String fileName = "yuejian";
    private final int mode = MODE_PRIVATE;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(fileName,mode);
        fragmentManager = getSupportFragmentManager();
        boolean loginState = getLoginState();
        if(loginState){
            //直接进入主界面
            setUserId(getSavedUserId());
            showMainFragment();


        }else{
            //显示登录
            showLoginFragment();

        }
    }
    private  void showMainFragment(){
        transaction = fragmentManager.beginTransaction();

        mainFragment = new MainFragment();
        transaction.add(R.id.fragment_holder,mainFragment);

        transaction.commit();

    }

    private  void showLoginFragment(){
        transaction = fragmentManager.beginTransaction();

        loginFragment = new LoginFragment();
        transaction.add(R.id.fragment_holder,loginFragment);

        transaction.commit();

    }
    public  void replaceLoginFragment(){
        mainFragment = new MainFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_holder,mainFragment);
        transaction.commit();
    }
    private boolean getLoginState(){

        userId=getSavedUserId();

        return !userId.equals("-1");

    }
    private String getSavedUserId(){
        String userId = preferences.getString("user_id","-1");
        return userId;
    }
    public void setSavedUserId(String userId){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user_id",userId);
        editor.commit();
    }
}
