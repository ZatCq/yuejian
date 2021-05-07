package com.example.admin.yuejian_22.Fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.admin.yuejian_22.Activity.SearchClubActivity;
import com.example.admin.yuejian_22.Adapter.ClubListAdapter;
import com.example.admin.yuejian_22.Base.BaseFragment;
import com.example.admin.yuejian_22.Bean.ClubList;
import com.example.admin.yuejian_22.Interf.RetrofitService;
import com.example.admin.yuejian_22.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubFragment extends BaseFragment {

    private RadioButton radio_p;
    private RadioButton radio_d;
    private RadioButton radio_search_club;
    private ClubPFragment clubPFragment;
    private ClubDFragment clubDFragment;
    private SearchClubActivity searchClubActivity;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    public ClubFragment() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {

        radio_p = (RadioButton) view.findViewById(R.id.radio_p);
        radio_d = (RadioButton) view.findViewById(R.id.radio_d);
        radio_search_club = (RadioButton) view.findViewById(R.id.radio_search_club);
        radio_p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    clubPFragment = new ClubPFragment();
                    replageFragment(clubPFragment);
                }

            }
        });
        radio_d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    clubDFragment = new ClubDFragment();
                    replageFragment(clubDFragment);


                }

            }
        });
        radio_search_club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio_d.setFocusable(true);
                radio_d.setFocusableInTouchMode(true);
                radio_d.requestFocus();
                radio_d.requestFocusFromTouch();

                Intent intent =new Intent(getActivity(),SearchClubActivity.class);



                startActivity(intent);
            }
        });

        fragmentManager = getChildFragmentManager();
        radio_p.setChecked(true);




    }
    private void replageFragment(Fragment fragment){
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_holder_club,fragment);
        transaction.commit();
    }

//        super.onViewCreated(view, savedInstanceState);



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_club, container, false);
    }

}
