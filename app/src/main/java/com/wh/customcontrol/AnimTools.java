package com.wh.customcontrol;
/*
 * 创建者 韦豪
 * 创建时间 2017/10/28 0028 19:14
 */

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimTools {


    //隐藏菜单

    /**
     * @param view  要执行动画的视图对象
     */
    public static void hideView(RelativeLayout view,  long offset) {

        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(
                0f,                     //开始角度
                -180f,                    //结束角度
                Animation.RELATIVE_TO_SELF,        //相对于自我，也就是屏幕
                0.5f,                   //旋转中心点,0.5f是指X轴的一半。
                Animation.RELATIVE_TO_SELF,
                1.0f);                  //旋转中心点，1f是指Y轴的整个高度。

        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(200);   //动画持续时间

        rotateAnimation.setStartOffset(offset);
        view.startAnimation(rotateAnimation);   //执行动画



    }

    //打开菜单
    public static void openView(RelativeLayout view,long offset) {

        RotateAnimation rotateAnimation = new RotateAnimation(-180f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);

        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);

        rotateAnimation.setStartOffset(offset);
        view.startAnimation(rotateAnimation);

    }





}
