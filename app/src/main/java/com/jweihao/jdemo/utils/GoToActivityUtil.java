package com.jweihao.jdemo.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by weihao on 2018/1/30.
 */

public class GoToActivityUtil {
    /*
    *
    * 跳转到指定Activity
    *
    *
    * */
    public static void goToActivity(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}
