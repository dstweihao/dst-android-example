package com.jweihao.jdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.jweihao.jdemo.bean.Data;
import com.jweihao.jdemo.ui.activity.example.TwitterDetailsActivity;
import com.jweihao.jdemo.view.CropCircleTransformation;
import com.jweihao.jdemo.view.MessagePicturesLayout;
import com.squareup.picasso.Picasso;
import com.wh.customcontrol.R;


import java.util.ArrayList;
import java.util.List;


public class MessageAdapter extends RecyclerView.Adapter {
    private final List<Data> mDataList = new ArrayList<>();
    private final CropCircleTransformation mCropCircleTransformation;
    private MessagePicturesLayout.Callback mCallback;
    private Data mData;
    private int type;

    public MessageAdapter(Context context) {
        mCropCircleTransformation = new CropCircleTransformation();
    }

    public MessageAdapter setPictureClickCallback(MessagePicturesLayout.Callback callback) {
        mCallback = callback;
        return this;
    }

    public void set(List<Data> dataList, int type) {
        mDataList.clear();
        if (dataList != null) {
            mDataList.addAll(dataList);
            this.type = type;
        }
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iAvatar;
        TextView tNickname, tTime, tContent;
        MessagePicturesLayout lPictures;

        private final View mItemView;

        ViewHolder(View itemView) {
            super(itemView);
            iAvatar = (ImageView) itemView.findViewById(R.id.i_avatar);
            tNickname = (TextView) itemView.findViewById(R.id.t_nickname);
            tTime = (TextView) itemView.findViewById(R.id.t_time);
            tContent = (TextView) itemView.findViewById(R.id.t_content);
            lPictures = (MessagePicturesLayout) itemView.findViewById(R.id.l_pictures);
            lPictures.setCallback(mCallback);
            mItemView = itemView;

        }

        void refresh(final int pos) {
            mData = mDataList.get(pos);
            Picasso.with(itemView.getContext()).load(mData.getAvatar()).placeholder(R.drawable.default_avatar)
                    .transform(mCropCircleTransformation)
                    .into(iAvatar);
            tNickname.setText(mData.getNickname());
            tTime.setText(mData.getCreateTime());
            tContent.setText(mData.getContent());
            lPictures.set(mData.getPictureThumbList(), mData.getPictureList());
            if (type == 1) {
                mItemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), TwitterDetailsActivity.class);
                        intent.putExtra("Data", mDataList.get(pos));
                        v.getContext().startActivity(intent);
                    }
                });
            }

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_main_message, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).refresh(position % mDataList.size());


    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
