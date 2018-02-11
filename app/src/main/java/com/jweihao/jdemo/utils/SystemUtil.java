package com.jweihao.jdemo.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by weihao on 2018/2/10.
 */

public class SystemUtil {

    /**
     * @param context
     * @return 获取堆的大小
     */
    public static int getHeapSize(Context context) {

        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        int heapSize = manager.getLargeMemoryClass();
        return heapSize;
    }


}
