package com.example.admin.yuejian_22.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.admin.yuejian_22.Base.BaseFragment;
import com.example.admin.yuejian_22.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {


    private TextView titleView;
    private RadioGroup radioGroup;

    private  TrainFragment trainFragment;
    private  ClubFragment clubFragment;
    private  HomeFragment homeFragment;
    private  PhotoFragment photoFragment;
    private  MyFragment myFragment;

    private FragmentManager manager;
    private FragmentTransaction transaction;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // titleView = (TextView) view.findViewById(R.id.textView_title);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        manager = getChildFragmentManager();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.radio_train:

                       trainFragment = new TrainFragment();
                        replace(trainFragment);
                        break;
                    case R.id.radio_club:
                        clubFragment = new ClubFragment();
                        replace(clubFragment);

                        break;
                    case R.id.radio_home:
                        homeFragment = new HomeFragment();
                        replace(homeFragment);
                        break;
                    case R.id.radio_photo:
                        photoFragment = new PhotoFragment();
                        replace(photoFragment);
                        break;
                    case R.id.radio_my:
                        myFragment = new MyFragment();
                        replace(myFragment);
                        break;
                }

            }
        });
    }


    private  void  replace(Fragment fragment){
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
