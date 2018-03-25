package com.jweihao.jdemo.ui.activity.md.viewBinder;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/25 0025 21:43
 */

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jweihao.jdemo.bean.Song;
import com.wh.customcontrol.R;

import me.drakeet.multitype.ItemViewBinder;

public class SongViewBinder extends ItemViewBinder<Song, SongViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Song item) {
        holder.mIv_song.setImageResource(item.getImage());
        holder.mTv_song.setText(item.getName());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv_song;
        private final ImageView mIv_song;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv_song = itemView.findViewById(R.id.song_name);
            mIv_song = itemView.findViewById(R.id.song_image);

        }
    }
}
