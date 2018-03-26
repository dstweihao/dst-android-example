package com.jweihao.jdemo.ui.activity.md.viewBinder;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jweihao.jdemo.bean.Post;
import com.wh.customcontrol.R;

import org.w3c.dom.Text;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by weihao on 2018/3/26.
 */

public class PostItemViewBinder extends ItemViewBinder<Post, PostItemViewBinder.Viewholder> {
    @NonNull
    @Override
    protected Viewholder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_post, parent, false);
        return new Viewholder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull Viewholder holder, @NonNull Post item) {
        holder.mIv_post.setImageResource(item.getImage());
        holder.mTv_post.setText(item.getName());
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private final ImageView mIv_post;
        private final TextView mTv_post;

        public Viewholder(final View itemView) {
            super(itemView);
            mIv_post = itemView.findViewById(R.id.iv_post);
            mTv_post = itemView.findViewById(R.id.tv_post);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "xxxx", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
