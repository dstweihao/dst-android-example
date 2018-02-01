package com.jweihao.jdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jweihao.jdemo.adapter.FragmentAdapter;
import com.jweihao.jdemo.bean.RecyclerData;
import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weihao on 2017/12/18.
 */

public class SportsFargment extends Fragment {
    private List<RecyclerData> mDates = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加Android自带的分割线
        recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        initDate();
        recyclerview.setAdapter(new FragmentAdapter(mDates));
        return view;
    }

    private void initDate() {

        for (int i = 0; i < 50; i++) {
            RecyclerData recyclerData = new RecyclerData(R.mipmap.sports, "北京时间1月14号，莱昂纳德完成对战掘金的比赛后。莱昂纳德进入马刺的队医的观察名单中，无法上场进行比赛。在这段养伤的期间，莱昂纳德拍摄了，祝中国球迷们新年快乐的祝福视频，莱昂纳德是今年第一个给中国球迷拜年的NBA球星。");
            mDates.add(recyclerData);
        }
    }
}
