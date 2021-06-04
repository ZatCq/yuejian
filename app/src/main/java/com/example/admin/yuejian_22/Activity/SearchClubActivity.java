package com.example.admin.yuejian_22.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


import com.example.admin.yuejian_22.Adapter.ClubSearchAdapter;
import com.example.admin.yuejian_22.Base.BaseActivity;
import com.example.admin.yuejian_22.Bean.ClubList;

import com.example.admin.yuejian_22.Listener.ClubSearchListener;

import com.example.admin.yuejian_22.Model.ClubModel;
import com.example.admin.yuejian_22.R;

import java.util.List;


public class SearchClubActivity extends BaseActivity implements View.OnClickListener{
    private ImageButton back_club;
    private Context Context;
private ClubModel clubModel;
    private View view = null;
    private List<ClubList> clubListsearch;
    private ClubSearchAdapter adapter = null;

    private Button button_search;
    private EditText keywordView;
    private ListView listView;
    private ClubSearchListener clubSearchListener = new ClubSearchListener() {
        @Override
        public void onResponse(List<ClubList> clubListsearch) {
            adapter.getSearchClub(clubListsearch);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onFail(String msg) {

        }
    };


    @Override
    public View onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        return null;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_club);
button_search = (Button) findViewById(R.id.button_search);
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String club_name = keywordView.getText().toString();

            }
        });
        /**
         * 初始化视图
         */

    }






//        back_club = (ImageButton) findViewById(R.id.back_club);
//        back_club.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                    System.out.print("1");
//                //Intent intent =new Intent(SearchClubActivity.this,ClubDFragment.class);
//
//                finish();
//            }
//        });






//







    @Override
    public void onClick(View view) {

    }


}
