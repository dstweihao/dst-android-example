package com.jweihao.jdemo.ui.activity.md.viewBinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jweihao.jdemo.bean.Post;
import com.jweihao.jdemo.bean.PostList;
import com.wh.customcontrol.R;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by weihao on 2018/3/26.
 */

public class HorizontalItemViewBinder extends ItemViewBinder<PostList, HorizontalItemViewBinder.ViewHolder> {

    private MultiTypeAdapter mAdapter;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_horizontal_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PostList postList) {
        holder.setPosts(postList.getPostList());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView mRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_recycler);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(layoutManager);

            mAdapter = new MultiTypeAdapter();
            mAdapter.register(Post.class, new PostItemViewBinder());
            mRecyclerView.setAdapter(mAdapter);
        }


        public void setPosts(List<Post> postList) {
            mAdapter.setItems(postList);
            mAdapter.notifyDataSetChanged();
        }
    }


}
