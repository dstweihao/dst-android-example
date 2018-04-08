package com.jweihao.jdemo.ui.activity.book.diyihang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jweihao.jdemo.ui.activity.MainActivity;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SPActivity extends AppCompatActivity {

    @BindView(R.id.save_data)
    Button mSaveData;
    @BindView(R.id.restore_data)
    Button mRestoreData;
    @BindView(R.id.sp_name)
    TextView mSpName;
    @BindView(R.id.sp_age)
    TextView mSpAge;
    @BindView(R.id.sp_married)
    TextView mSpMarried;
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_userpass)
    EditText mEtUserpass;
    @BindView(R.id.cb_remember)
    CheckBox mCbRemember;
    @BindView(R.id.login)
    Button mLogin;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        ButterKnife.bind(this);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = mPreferences.getBoolean("remember_password", false);
        if (isRemember) {
            //将账号和密码都设置到文本框中
            String userName = mPreferences.getString("userName", "");
            String userPass = mPreferences.getString("userPass", "");
            mEtUsername.setText(userName);
            mEtUserpass.setText(userPass);
            mCbRemember.setChecked(true);
        }
    }

    @OnClick({R.id.cb_remember, R.id.login, R.id.save_data, R.id.restore_data})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //保存数据
            case R.id.save_data:
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "jweihao");
                editor.putInt("age", 28);
                editor.putBoolean("married", false);
                editor.apply();
                break;
            //还原数据
            case R.id.restore_data:
                SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
                String name = sp.getString("name", "");
                int age = sp.getInt("age", 0);
                boolean married = sp.getBoolean("married", false);
                mSpName.setText("姓名：" + name);
                mSpAge.setText("年龄：" + age);
                mSpMarried.setText("婚否：" + married);
                break;
            //记住密码
            case R.id.cb_remember:
                break;
            //登录
            case R.id.login:
                String userName = mEtUsername.getText().toString().trim();
                String userPass = mEtUserpass.getText().toString().trim();
                //如果账号是jweihao 且密码是123456，就认为登录成功。
                if (userName.equals("jweihao") && userPass.equals("123456")) {
                    mEdit = mPreferences.edit();
                    //检查复选框是否被选中
                    if (mCbRemember.isChecked()) {
                        mEdit.putBoolean("remember_password", true);
                        mEdit.putString("userName", userName);
                        mEdit.putString("userPass", userPass);
                    } else {
                        mEdit.clear();
                    }
                    mEdit.apply();
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "用户名或者密码不正确，请重新输入！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

}
