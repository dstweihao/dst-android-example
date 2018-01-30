package com.wh.customcontrol.utils;
/*
 * @author weihao
 * @time 2017/10/28 0028 19:14
 */



import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimTools {


    //隐藏菜单

    /**
     * @param view 要执行动画的视图对象
     */
    public static void hideView(RelativeLayout view, long offset) {

        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(
                //开始角度
                0f,
                //结束角度
                -180f,
                //相对于自我，也就是屏幕
                Animation.RELATIVE_TO_SELF,
                //旋转中心点,0.5f是指X轴的一半。
                0.5f,
                Animation.RELATIVE_TO_SELF,
                //旋转中心点，1f是指Y轴的整个高度。
                1.0f);

        rotateAnimation.setFillAfter(true);
        //动画持续时间
        rotateAnimation.setDuration(200);

        rotateAnimation.setStartOffset(offset);
        //执行动画
        view.startAnimation(rotateAnimation);


    }

    /*打开菜单*/
    public static void openView(RelativeLayout view, long offset) {

        RotateAnimation rotateAnimation = new RotateAnimation(-180f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);

        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);

        rotateAnimation.setStartOffset(offset);
        view.startAnimation(rotateAnimation);

    }


}
