package com.example.admin.yuejian_22.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Admin on 2017/9/25.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter{
    protected Context context;
    protected List data;
    protected LayoutInflater layoutInflater;

    public BaseAdapter(Context context,List data){
        this.context = context;
        this.data = data;
        layoutInflater = layoutInflater.from(context);

    }
    abstract RecyclerView.ViewHolder onCreateVH(ViewGroup parent, LayoutInflater layoutInflater, int viewType);
    abstract void onBindVH(RecyclerView.ViewHolder holder,List data,int position);


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindVH(holder,data,position);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateVH(parent,layoutInflater,viewType);
    }

}
