package com.jweihao.jdemo.ui.activity.example;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.squareup.picasso.Picasso;

import com.wh.customcontrol.R;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class GlassActivity extends AppCompatActivity {
    private ImageView blurImageView;
    private ImageView avatarImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass);
        initView();
        initData();
    }


    private void initView() {
        blurImageView = (ImageView) findViewById(R.id.iv_blur);

        avatarImageView = (ImageView) findViewById(R.id.iv_avatar);

    }

    private void initData() {
//        Glide.with(this).load(R.mipmap.zhishui)
//                .bitmapTransform(new BlurTransformation(this, 25), new CenterCrop(this))
//                .into(blurImageView);
//        Glide.with(this).load(R.mipmap.zhishui)
//                .bitmapTransform(new CropCircleTransformation(this))
//                .into(avatarImageView);
        Picasso.with(this)
                .load(R.mipmap.zhishui)
                .transform(new BlurTransformation(this, 25)).into(blurImageView);
        Picasso.with(this).load(R.mipmap.zhishui)
                .transform(new CropCircleTransformation())
                .into(avatarImageView);


    }
}
