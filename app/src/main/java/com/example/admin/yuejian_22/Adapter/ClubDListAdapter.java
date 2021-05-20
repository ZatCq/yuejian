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
 * Created by Admin on 2017/9/27.
 */

public class ClubDListAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ClubList> clubLists;
    private LayoutInflater LayoutInflater;
    public String imageUrl;

    public ClubDListAdapter(Context context, List<ClubList> clubListList) {
        this.context = context;
        this.clubLists = clubListList;
        LayoutInflater = LayoutInflater.from(context);
    }

    public void getNearClub(List<ClubList> clubLists)
    {
        this.clubLists= clubLists ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club_d, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final  ClubList entity=clubLists.get(position);
        if (null==entity)return;
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.club_name_d.setText(entity.getClub_name());
        if (!entity.getThumb().isEmpty()){
            Picasso.with(context).load("http://172.24.10.175/workout/Uploads/"+entity.getThumb()).into(viewHolder.img_club_d);
        }else {
            viewHolder.img_club_d.setImageResource(R.drawable.ic_club);
        }
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_club_d;
        TextView club_name_d;
        public ViewHolder(View itemView) {
            super(itemView);

            img_club_d = (ImageView) itemView.findViewById(R.id.img_club_d);
            club_name_d = (TextView) itemView.findViewById(R.id.club_name_d);

        }
    }


    @Override
    public int getItemCount() {
        return clubLists.size();
    }

}






