package com.jweihao.jdemo.ui.activity.sdk;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.MapView;
import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GaoDeActivity extends AppCompatActivity {

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationClientOption = null;
    @BindView(R.id.type)
    TextView mType;
    @BindView(R.id.weidu)
    TextView mWeidu;
    @BindView(R.id.jingdu)
    TextView mJingdu;
    @BindView(R.id.jingque)
    TextView mJingque;
    @BindView(R.id.dizhi)
    TextView mDizhi;
    @BindView(R.id.country)
    TextView mCountry;
    @BindView(R.id.province)
    TextView mProvince;
    @BindView(R.id.city)
    TextView mCity;
    @BindView(R.id.district)
    TextView mDistrict;
    @BindView(R.id.street)
    TextView mStreet;
    @BindView(R.id.streetnum)
    TextView mStreetnum;
    @BindView(R.id.citycode)
    TextView mCitycode;
    @BindView(R.id.addcode)
    TextView mAddcode;
    @BindView(R.id.aoiName)
    TextView mAoiName;
    @BindView(R.id.gaode_mapview)
    MapView mGaodeMapview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gao_de);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        //运行时权限的获取
        initPermissions();

    }

    private void initLocation() {

        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);

        //初始化AMapLocationClientOption对象
//        mLocationClientOption = new AMapLocationClientOption();
        /*
        * 设置定位场景，目前支持三种场景（签到，出行，运动，默认无场景）
        * */
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        if (null != mLocationClient) {
            mLocationClient.setLocationOption(option);
            //设置场景模式最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        }
        //设置高精度模式
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置获取最近3s内精度最高的一次定位结果.
        option.setOnceLocationLatest(true);
        //设置是否返回地址信息（默认返回地址信息）
        option.setNeedAddress(true);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(option);
        //启动定位
        mLocationClient.startLocation();


    }

    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {

            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应的内容。
                    mType.setText(aMapLocation.getLocationType());
                    mWeidu.setText("" + aMapLocation.getLatitude());
                    mJingdu.setText("" + aMapLocation.getLongitude());
                    mJingque.setText("" + aMapLocation.getAccuracy());
                    mDizhi.setText(aMapLocation.getAddress());

                } else {
                    //定位失败，可通过ErrCode（错误码）消息来确定失败的原因
                    //errInfo是错误信息，详见错误码表.
                    Toast.makeText(GaoDeActivity.this, "定位失败！", Toast.LENGTH_SHORT).show();

                }
            }

        }
    };

    private void initPermissions() {
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(GaoDeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(GaoDeActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(GaoDeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(GaoDeActivity.this, permissions, 1);

        } else {
            //获取到权限之后，才继续操作
            //初始化定位
            initLocation();
        }
    }
}
