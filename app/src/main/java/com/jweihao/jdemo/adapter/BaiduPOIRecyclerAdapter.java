package com.jweihao.jdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.location.Poi;
import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihao on 2018/3/12.
 */

public class BaiduPOIRecyclerAdapter extends RecyclerView.Adapter<BaiduPOIRecyclerAdapter.ViewHolder> {


    private List<Poi> poiLists = new ArrayList<>();

    public BaiduPOIRecyclerAdapter(List<Poi> poiList) {
        poiLists = poiList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mId;
        private final TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.item_id);
            mName = itemView.findViewById(R.id.item_name);
        }
    }

    @Override
    public BaiduPOIRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baidu_poi_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaiduPOIRecyclerAdapter.ViewHolder holder, int position) {
        Poi poi = poiLists.get(position);
        holder.mId.setText(poi.getId());
        holder.mName.setText(poi.getName());

    }

    @Override
    public int getItemCount() {
        return poiLists.size();
    }


}
