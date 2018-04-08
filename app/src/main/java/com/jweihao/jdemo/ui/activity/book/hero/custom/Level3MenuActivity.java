package com.jweihao.jdemo.ui.activity.book.hero.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.jweihao.jdemo.utils.AnimTools;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Level3MenuActivity extends AppCompatActivity {

    @BindView(R.id.iv_menu)
    ImageView mIvMenu;
    @BindView(R.id.iv_home)
    ImageView mIvHome;
    @BindView(R.id.ll_level3)
    RelativeLayout mLlLevel3;
    @BindView(R.id.iv_level2)
    RelativeLayout mIvLevel2;
    boolean isOpen = true;
    boolean isOpen2 = true;
    public static long offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_menu, R.id.iv_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            //一级菜单
            case R.id.iv_home:

                if (isOpen2) {

                    AnimTools.hideView(mLlLevel3, offset);

                    offset += 300;
                    AnimTools.hideView(mIvLevel2, offset);
                    isOpen2 = false;
                } else {
                    AnimTools.openView(mIvLevel2, offset);
                    offset += 300;
                    AnimTools.openView(mLlLevel3, offset);
                    isOpen2 = true;
                }

                offset = 0;


                break;
            //二级菜单
            case R.id.iv_menu:


                if (isOpen) {
                    //点击了隐藏
                    AnimTools.hideView(mLlLevel3, offset);
                    isOpen = false;
                } else {
                    //点击打开菜单
                    AnimTools.openView(mLlLevel3, offset);
                    isOpen = true;
                }


                break;

            default:
                break;

        }
    }
}
