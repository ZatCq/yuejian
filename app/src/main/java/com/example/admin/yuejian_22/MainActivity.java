package com.example.admin.yuejian_22;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.admin.yuejian_22.Base.BaseActivity;
import com.example.admin.yuejian_22.Fragment.MainFragment;

public class MainActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private MainFragment mainFragment;
    private SharedPreferences preferences;
    private final String fileName = "yuejain";
    private final int mode = MODE_PRIVATE;


    @Override
    public View onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(fileName,mode);
        fragmentManager = getSupportFragmentManager();
        showMainFragment();
    }
    private  void showMainFragment(){
        transaction = fragmentManager.beginTransaction();

        mainFragment = new MainFragment();
        transaction.add(R.id.fragment_holder,mainFragment);

        transaction.commit();

    }
}
