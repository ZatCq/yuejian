package com.example.admin.yuejian_22.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.yuejian_22.Activity.ClubActivity;
import com.example.admin.yuejian_22.Bean.ClubList;
import com.example.admin.yuejian_22.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 2017/9/26.
 */


public class ClubListAdapter extends RecyclerView.Adapter {

private Context Context;
    private List<ClubList> clubListList;
    private LayoutInflater LayoutInflater;


    public ClubListAdapter(Context Context, List<ClubList> clubListList) {
        this.Context = Context;
        this.clubListList = clubListList;
        LayoutInflater = LayoutInflater.from(Context);
    }
    public void getAllClub(List<ClubList> clubListList)
    {
        this.clubListList= clubListList ;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club_p, parent, false);
        return new ClubListAdapter.ViewHolder(v);

    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final  ClubList entity=clubListList.get(position);
        final String club_name = entity.getClub_name();
        if (null==entity)return;
        ClubListAdapter.ViewHolder viewHolder = ( ClubListAdapter.ViewHolder) holder;
        viewHolder.club_name.setText(entity.getClub_name());

        if (!entity.getThumb().isEmpty()){
            Picasso.with(Context).load("http://172.24.10.175/workout/Uploads/"+entity.getThumb()).into(viewHolder.img_club);
        }else {
            viewHolder.img_club.setImageResource(R.drawable.ic_club);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent();*/

                Intent intent =new Intent(Context,ClubActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id",entity.getId());
                intent.putExtra("club_name",entity.getClub_name());

                /*intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;*/
                Context.startActivity(intent);


            }
        });

    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_club;
        TextView club_name;

        public ViewHolder(View itemView) {
            super(itemView);
            img_club = (ImageView) itemView.findViewById(R.id.img_club);
            club_name = (TextView) itemView.findViewById(R.id.club_name);

        }
    }

    @Override
    public int getItemCount() {
        return clubListList.size();
    }
    }
