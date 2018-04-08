package com.jweihao.jdemo.ui.activity.book.diyihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class zhang7Activity extends AppCompatActivity {

    @BindView(R.id.button_permission)
    Button mButtonPermission;
    @BindView(R.id.button_otherdata)
    Button mButtonOtherdata;
    @BindView(R.id.button_contacts)
    Button mButtonContacts;
    @BindView(R.id.button_myprovider)
    Button mButtonMyprovider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang7);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_permission, R.id.button_otherdata, R.id.button_contacts, R.id.button_myprovider})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_permission:
                GoToActivityUtil.goToActivity(this, PermissionActivity.class);
                break;
            case R.id.button_otherdata:
                break;
            case R.id.button_contacts:
                GoToActivityUtil.goToActivity(this, ContactsActivity.class);
                break;
            case R.id.button_myprovider:
                GoToActivityUtil.goToActivity(this, MyProviderActivity.class);
                break;
            default:
                break;
        }
    }

}
