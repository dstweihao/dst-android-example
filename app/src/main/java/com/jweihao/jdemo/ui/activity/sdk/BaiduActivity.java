package com.jweihao.jdemo.ui.activity.sdk;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

public class BaiduActivity extends AppCompatActivity {

    private LocationClient mLocationClient;
    private TextView mPositionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClient = new LocationClient(getApplicationContext());
        //注册一个定位监听器，当获取到位置信息的时候，就会回调这个定位监听器
        mLocationClient.registerLocationListener(new MyLocationListener());
        setContentView(R.layout.activity_baidu);
        mPositionText = (TextView) findViewById(R.id.position_text_view);
        //运行时权限的获取
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(BaiduActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(BaiduActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(BaiduActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(BaiduActivity.this, permissions, 1);

        } else {
            requestLocation();
        }
    }

    private void requestLocation() {
        initLocation();
        mLocationClient.start();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        //强制指定只使用GPS进行定位
        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        option.setScanSpan(5000);
        //表示我们需要获取当前位置详细的地址信息
        //由于获取地址信息一定需要用到网络，因此即使我们将定位模式指定成Device_Sensors，也会自动开启网络定位功能。
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation Location) {

            StringBuffer currentPosition = new StringBuffer();
            currentPosition.append("纬度：").append(Location.getLatitude()).append("\n");
            currentPosition.append("经线：").append(Location.getLatitude()).append("\n");
            currentPosition.append("国家：").append(Location.getCountry()).append("\n");
            currentPosition.append("省：").append(Location.getProvince()).append("\n");
            currentPosition.append("市：").append(Location.getCity()).append("\n");
            currentPosition.append("区：").append(Location.getDistrict()).append("\n");
            currentPosition.append("街道：").append(Location.getStreet()).append("\n");
            currentPosition.append("定位方式：");
            if (Location.getLocType() == BDLocation.TypeGpsLocation) {
                currentPosition.append("GPS");
            } else if (Location.getLocType() == BDLocation.TypeNetWorkLocation) {
                currentPosition.append("网络");
            }
            mPositionText.setText(currentPosition);
        }
    }

}
