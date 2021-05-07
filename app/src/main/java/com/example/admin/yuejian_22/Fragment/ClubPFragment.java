package com.example.admin.yuejian_22.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.yuejian_22.Activity.ClubActivity;
import com.example.admin.yuejian_22.Adapter.ClubListAdapter;
import com.example.admin.yuejian_22.Base.BaseFragment;
import com.example.admin.yuejian_22.Base.ItemClickSupport;
import com.example.admin.yuejian_22.Bean.ClubList;
import com.example.admin.yuejian_22.Model.ClubModel;
import com.example.admin.yuejian_22.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubPFragment extends BaseFragment {
    public RecyclerView recyclerView;
    private List<ClubList> clubListList;
    private View view = null;
    public ClubPFragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_club_p, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_p);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getData();
        return view;
    }
    private ClubList getData() {
        ClubList clubListList = new ClubList();

        ClubModel clubModel = new ClubModel();

        Call<List<ClubList>> call = clubModel.getAllClub();

        call.enqueue(new Callback<List<ClubList>>() {
            @Override
            public void onResponse(Call<List<ClubList>> call, Response<List<ClubList>> response) {
                final List<ClubList> clubListList = response.body();
                recyclerView.setAdapter(new ClubListAdapter(getContext(), clubListList));
                ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        ClubList clubList = clubListList.get(position);
                        Intent intent = new Intent(getActivity(), ClubActivity.class);
                        intent.putExtra("id", clubList.getId() + "");
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<ClubList>> call, Throwable t) {

            }
        });
        return clubListList;
    }
//    public RecyclerView recyclerView;
//    private ClubListAdapter adapter;
//    private TextView clubNameView;
//    private ImageView club_img;
//
//
//    public ClubPFragment() {
//    }
//
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_p);
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.24.10.175/workout/api.php/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//
//        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
//
//        Call<List<ClubList>> clublistCall= retrofitService.getAllClub();
//        clublistCall.enqueue(new Callback<List<ClubList>>() {
//            @Override
//            public void onResponse(Call<List<ClubList>> call, Response<List<ClubList>> response) {
//                List ClubListList = (List) response.body();
//                if (getActivity()==null)
//                    return;
//                ClubListAdapter adapter = new ClubListAdapter(getActivity(),ClubListList);
//                recyclerView = (RecyclerView) recyclerView.findViewById(R.id.recycleView_p);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                recyclerView.setLayoutManager(linearLayoutManager);
//                recyclerView.setAdapter(adapter);
//                recyclerView.setItemAnimator(new DefaultItemAnimator());
//            }
//
//            @Override
//            public void onFailure(Call<List<ClubList>> call, Throwable t) {
//
//            }
//        });}
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_club_p, container, false);
//    }

}
