package com.example.admin.yuejian_22.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.yuejian_22.R;

/**
 * Created by Admin on 2017/9/27.
 */

public class ClubItemViewHolder extends RecyclerView.ViewHolder {
    public static ImageView img_club;
    public TextView clubNameView;
    public View itemView;
    public ClubItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        img_club = (ImageView) itemView.findViewById(R.id.img_club);
        clubNameView = (TextView) itemView.findViewById(R.id.club_name);

    }
}














