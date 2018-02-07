package com.jweihao.jdemo.ui.activity.md;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihao on 2018/2/7.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<String> mList = new ArrayList<>();
    private OnItemClickListener itemClickListener;

    public RecyclerAdapter(List<String> list) {
        mList = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mTv_item;

        public ViewHolder(View itemView) {
            super(itemView);

            mTv_item = itemView.findViewById(R.id.tv_recycleritem);
            itemView.setOnClickListener(this);
        }

        //通过接口回调来实现RecyclerView的点击事件
        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(v, getPosition());
            }
        }
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.mTv_item.setText(mList.get(position) + " " + position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /*
    * Android 并没有给RecyclerView增进点击事件，所以
    * 我们需要自己使用接口回调机制，创建一个点击事件的接口。
    * */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
