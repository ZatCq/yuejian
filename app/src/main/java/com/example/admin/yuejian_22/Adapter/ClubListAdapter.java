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
 * Created by Admin on 2017/9/26.
 */


public class ClubListAdapter extends RecyclerView.Adapter {
//    private List<ClubList> clubListList = new ArrayList<>();
//
//    public Context context;
// public String imageUrl;
//    private LayoutInflater layoutInflater;
//    public ClubListAdapter(FragmentActivity context, List clubListList){
//        this.context = context;
//        layoutInflater = LayoutInflater.from(context);
//        this.clubListList.addAll(clubListList);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = layoutInflater.inflate(R.layout.item_club_p,parent,false);
//        ClubItemViewHolder holder=new ClubItemViewHolder(itemView);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        ClubItemViewHolder clubItemViewHolder = (ClubItemViewHolder) holder;
//        final ClubList clubList = clubListList.get(position);
//        final String clubName = clubList.getClub_name();
//        String thumb = clubList.getThumb();
//        String id = clubList.getId();
//        clubItemViewHolder.clubNameView.setText(clubName);
//        imageUrl = thumb;
//       // System.out.println(imageUrl);
//        Picasso.with(context).load("http://172.24.10.175/workout/Uploads/"+imageUrl).into(ClubItemViewHolder.img_club);
//        clubItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
private Context Context;
    private List<ClubList> clubListList;
    private LayoutInflater LayoutInflater;
    public String imageUrl;

    public ClubListAdapter(Context Context, List<ClubList> clubListList) {
        this.Context = Context;
        this.clubListList = clubListList;
        LayoutInflater = LayoutInflater.from(Context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club_p, parent, false);
        return new ClubListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ClubList entity = clubListList.get(position);
        if (null == entity)
            return;
        ClubListAdapter.ViewHolder viewHolder = (ClubListAdapter.ViewHolder) holder;
//        entity.setClub_name("1111");
        viewHolder.club_name.setText(entity.getClub_name());
        System.out.println(entity.getThumb());
        Picasso.with(Context).load("http://172.24.10.175/workout/Uploads/"+ entity.getThumb()).into(viewHolder.img_club);
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
