package com.jweihao.jdemo.ui.activity.md;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.spinner)
    Spinner mSpinner;
    @BindView(R.id.button_add)
    Button mButtonAdd;
    @BindView(R.id.button_del)
    Button mButtonDel;

    private List<String> mList = new ArrayList<>();
    private RecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initData() {
        //增加测试数据
        mList.add("RecyclerView");
        mList.add("RecyclerView");
        mList.add("RecyclerView");
        mRecyclerAdapter = new RecyclerAdapter(mList);
        mRecyclerview.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {
                //设置点击动画
                view.animate()
                        .translationZ(15F).setDuration(1000)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                view.animate()
                                        .translationZ(1f)
                                        .setDuration(1000)
                                        .start();
                            }
                        })
                        .start();

            }
        });

    }

    private void initView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setHasFixedSize(true);
        //设置显示动画
        mRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //设置为线性布局
                    mRecyclerview.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
                } else if (position == 1) {
                    //设置为表格布局
                    mRecyclerview.setLayoutManager(new GridLayoutManager(RecyclerActivity.this, 3));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick({R.id.button_add, R.id.button_del})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                mList.add("RecyclerView");
                int addPosition = mList.size();
                if (addPosition > 0) {
                    //适配器刷新
                    mRecyclerAdapter.notifyDataSetChanged();
                }

                break;
            case R.id.button_del:
                int delPosition = mList.size();
                if (delPosition > 0) {
                    mList.remove(delPosition - 1);
                    mRecyclerAdapter.notifyDataSetChanged();
                }
                break;
            default:
                break;
        }
    }
}
