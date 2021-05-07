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
    private List<ClubList> clubListList;
    private LayoutInflater LayoutInflater;
    public String imageUrl;

    public ClubDListAdapter(Context context, List<ClubList> clubListList) {
        this.context = context;
        this.clubListList= clubListList ;
        LayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club_d, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ClubList entity = clubListList.get(position);
        if (null == entity)
            return;
        ClubDListAdapter.ViewHolder viewHolder = (ClubDListAdapter.ViewHolder) holder;

//        entity.setClub_name("1111");
        viewHolder.club_name_d.setText(entity.getClub_name());
        Picasso.with(this.context).load("http://172.24.10.175/workout/Uploads/"+ entity.getThumb()).into(viewHolder.img_club_d);
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
        return clubListList.size();
    }
//    public List<ClubList> clubListList = new ArrayList<>();
//    public Context context;
//    public String imageUrl;
//    private LayoutInflater layoutInflater;
//    public ClubDListAdapter(FragmentActivity context, List clubListList){
//        this.context = context;
//        layoutInflater = LayoutInflater.from(context);
//        this.clubListList.addAll(clubListList);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = layoutInflater.inflate(R.layout.item_club_d,parent,false);
//        ClubDItemViewHolder holder=new ClubDItemViewHolder(itemView);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        ClubDItemViewHolder clubDItemViewHolder = (ClubDItemViewHolder) holder;
//        final ClubList clubList = clubListList.get(position);
//        final String clubName = clubList.getClub_name();
//        String thumb = clubList.getThumb();
//        String id = clubList.getId();
//        clubDItemViewHolder.clubdNameView.setText(clubName);
//        imageUrl = thumb;
//        System.out.println(imageUrl);
//        Picasso.with(context).load("http://172.24.10.175/workout/Uploads/"+imageUrl).into(ClubDItemViewHolder.img_club_d);
//        clubDItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "俱乐部详情" + position, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, ClubActivity.class);
//                intent.putExtra("id", clubList.getId());
//                intent.putExtra("club_name",clubName);
//
//                context.startActivity(intent);
//
//            }
//        });
//    }
//    @Override
//    public int getItemCount() {
//        return clubListList.size();
//    }
}
