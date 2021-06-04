package com.example.admin.yuejian_22.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.yuejian_22.Bean.ClubList;
import com.example.admin.yuejian_22.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 2017/10/11.
 */

public class ClubSearchAdapter extends RecyclerView.Adapter  {
    private android.content.Context Context;
    private List<ClubList> clubListsearch;
    private android.view.LayoutInflater LayoutInflater;
    public ClubSearchAdapter(Context Context, List<ClubList> clubListsearch) {
        this.Context = Context;
        this.clubListsearch = clubListsearch;
        LayoutInflater = LayoutInflater.from(Context);
    }
    public void getSearchClub(List<ClubList> clubListsearch)
    {
        this.clubListsearch= clubListsearch ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club_search, parent, false);
        return new ClubSearchAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final  ClubList entity=clubListsearch.get(position);
        if (null==entity)return;
        ClubSearchAdapter.ViewHolder viewHolder = ( ClubSearchAdapter.ViewHolder) holder;
        viewHolder.club_name_search.setText(entity.getClub_name());
        if (!entity.getThumb().isEmpty()){
            Picasso.with(Context).load("http://172.24.10.175/workout/Uploads/"+entity.getThumb()).into(viewHolder.img_club_search);
        }else {
            viewHolder.img_club_search.setImageResource(R.drawable.ic_club);
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_club_search;
        TextView club_name_search;

        public ViewHolder(View itemView) {
            super(itemView);
            img_club_search = (ImageView) itemView.findViewById(R.id.img_club_search);
            club_name_search = (TextView) itemView.findViewById(R.id.club_name_search);

        }
    }

    @Override
    public int getItemCount() {
        return clubListsearch.size();
    }
}


