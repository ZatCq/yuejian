package com.example.admin.yuejian_22.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.yuejian_22.Activity.ClubActivity;
import com.example.admin.yuejian_22.Adapter.ClubDListAdapter;
import com.example.admin.yuejian_22.Base.BaseFragment;
import com.example.admin.yuejian_22.Base.ItemClickSupport;
import com.example.admin.yuejian_22.Bean.ClubList;
import com.example.admin.yuejian_22.Listener.ClubDListListener;
import com.example.admin.yuejian_22.Listener.ClubListener;
import com.example.admin.yuejian_22.Model.ClubModel;
import com.example.admin.yuejian_22.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubDFragment extends Fragment implements ClubDListListener {

    public RecyclerView recyclerView;

    private List<ClubList> clubLists;
    private View view = null;
    private ClubDListAdapter adapter = null;
    private Context context;

    private ClubDListListener clubDListListener = new ClubDListListener() {
        @Override
        public void onResponse(List<ClubList> clubLists) {
            adapter.getNearClub(clubLists);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onFail(String msg) {

        }
    };

    public ClubDFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_club_d, container, false);
        initRecyclerView(view);
        ClubModel model = new ClubModel();
        model.getNearClub("id","club_name",this);


        return view;
    }


    public  void initRecyclerView(View view){
//
      recyclerView=(RecyclerView) view.findViewById(R.id.recycleView_d);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
   }
    @Override
    public void onResponse(List<ClubList> clubLists) {
        clubLists= clubLists;
       recyclerView.setAdapter(new ClubDListAdapter(getActivity(),clubLists));

    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}





