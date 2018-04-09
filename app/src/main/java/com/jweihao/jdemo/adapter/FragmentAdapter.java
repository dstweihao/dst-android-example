package com.jweihao.jdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jweihao.jdemo.bean.RecyclerData;
import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihao on 2017/12/18.
 */

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.ViewHolder> {

    private List<RecyclerData> mDates = new ArrayList<>();

    public FragmentAdapter(List<RecyclerData> dates) {
        mDates = dates;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView mImage;
        private final TextView mTextview;
        private final View mItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mImage = itemView.findViewById(R.id.imageview);
            mTextview = itemView.findViewById(R.id.textview);


        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RecyclerData recyclerData = mDates.get(position);
        holder.mImage.setImageResource(recyclerData.getImage());
        holder.mTextview.setText(recyclerData.getName());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "这是第 " + position + " 条item", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return mDates.size();
    }


}
