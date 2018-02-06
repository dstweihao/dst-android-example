package com.jweihao.jdemo.ui.activity.md;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.Window;

import com.wh.customcontrol.R;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.snow);
        //创建Palette对象,该方法过时。
        Palette.generateAsync(bitmap,
                new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        // 通过Palette来获取对应的色调
                        Palette.Swatch vibrant =
                                palette.getDarkVibrantSwatch();
                        // 将颜色设置给相应的组件
                        getActionBar().setBackgroundDrawable(
                                new ColorDrawable(vibrant.getRgb()));
                        Window window = getWindow();
                        window.setStatusBarColor(vibrant.getRgb());
                    }
                });
        //创建Palette对象
//        Palette.Builder builder = Palette.from(bitmap);
//        builder.generate(new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(@NonNull Palette palette) {
//                // 通过Palette来获取对应的色调
//                Palette.Swatch vibrant =
//                        palette.getDarkVibrantSwatch();
//                // 将颜色设置给相应的组件
//                getActionBar().setBackgroundDrawable(
//                        new ColorDrawable(vibrant.getRgb()));
//                Window window = getWindow();
//                window.setStatusBarColor(vibrant.getRgb());
//            }
//
//        });
    }
}
