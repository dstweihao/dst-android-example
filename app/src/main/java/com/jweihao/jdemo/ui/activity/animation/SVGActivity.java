package com.jweihao.jdemo.ui.activity.animation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SVGActivity extends AppCompatActivity {


    @BindView(R.id.imageview_test)
    ImageView mImageviewTest;
    @BindView(R.id.imageview_graph)
    ImageView mImageviewGraph;
    @BindView(R.id.imageview_earth)
    ImageView mImageviewEarth;
    @BindView(R.id.imageview_search)
    ImageView mImageviewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.imageview_test, R.id.imageview_graph, R.id.imageview_earth,
            R.id.imageview_search
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageview_test:
                //开始SVG动画
                ((Animatable) mImageviewTest.getDrawable()).start();
                break;
            case R.id.imageview_graph:
                Drawable graph = mImageviewGraph.getDrawable();
                if (graph instanceof Animatable) {
                    ((Animatable) graph).start();
                }
                break;
            case R.id.imageview_earth:
                Drawable earth = mImageviewEarth.getDrawable();
                if (earth instanceof Animatable) {
                    ((Animatable) earth).start();
                }
                break;
            case R.id.imageview_search:
                Drawable search = mImageviewSearch.getDrawable();
                if (search instanceof Animatable) {
                    ((Animatable) search).start();
                }
                break;
            default:
                break;
        }
    }
}
