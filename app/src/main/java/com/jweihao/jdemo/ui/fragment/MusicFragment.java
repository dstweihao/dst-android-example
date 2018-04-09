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

public class MusicFragment extends Fragment {
    private List<RecyclerData> mDates = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加Android自带的分割线
//        recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        initDate();
        recyclerview.setAdapter(new FragmentAdapter(mDates));
        return view;
    }

    private void initDate() {

        for (int i = 0; i < 50; i++) {
            RecyclerData recyclerData = new RecyclerData(R.mipmap.music, "   什么爱不说就已经存在，什么爱望着就全都明白，你笑一点一点一滴漾开，一字一句形容不来，是星空上的银海，我后来会在纯白的礼堂，牵好久的手交给另个他，眼泪一点一点一滴流下，感动也会跟着留下，远远看着你们幸福，像前世我们有过的模样。");
            mDates.add(recyclerData);
        }
    }
}
