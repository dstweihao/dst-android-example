package com.jweihao.jdemo.ui.activity.md.viewBinder;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/25 0025 21:18
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jweihao.jdemo.bean.Category;
import com.wh.customcontrol.R;

import me.drakeet.multitype.ItemViewBinder;

public class CategoryViewBinder extends ItemViewBinder<Category, CategoryViewBinder.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv_category;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv_category = itemView.findViewById(R.id.tv_category);
        }
    }

    @NonNull
    @Override
    protected CategoryViewBinder.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull CategoryViewBinder.ViewHolder holder, @NonNull Category category) {
        holder.mTv_category.setText(category.text);
    }


}
