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

public class NewsFargment extends Fragment {

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
            RecyclerData recyclerData = new RecyclerData(R.mipmap.news, "7月1日，俄罗斯总统普京在与芬兰总统尼尼斯特举行的联合新闻发布会上表示，无论芬兰是否加入北约，俄罗斯都尊重芬兰的选择，但加入北约意味着芬兰国防部队将不再独立，俄罗斯军队也将相应重新进行部署。");
            mDates.add(recyclerData);
        }
    }
}
