package com.jweihao.jdemo.ui.activity.diyihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SQLiteActivity extends AppCompatActivity {

    @BindView(R.id.button_create)
    Button mButtonCreate;
    private MyDatabaseHelper mDbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        ButterKnife.bind(this);
        mDbhelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);

    }

    @OnClick(R.id.button_create)
    public void onViewClicked() {
        mDbhelper.getWritableDatabase();
    }
}
