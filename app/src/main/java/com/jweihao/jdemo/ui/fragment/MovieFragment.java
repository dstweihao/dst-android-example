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

public class MovieFragment extends Fragment {
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
            RecyclerData recyclerData = new RecyclerData(R.mipmap.movie, "《霸王别姬》是汤臣电影有限公司出品的文艺片，该片改编自李碧华的同名小说，由陈凯歌执导，李碧华、芦苇编剧；张国荣、巩俐、张丰毅领衔主演。影片围绕两位京剧伶人半个世纪的悲欢离合，展现了对传统文化、人的生存状态及人性的思考与领悟。1993年该片在中国内地以及中国香港上映，此后在世界多个国家和地区公映，并且打破中国内地文艺片在美国的票房纪录。");
            mDates.add(recyclerData);
        }
    }
}
