package com.jweihao.jdemo.ui.activity.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jweihao.jdemo.bean.Category;
import com.jweihao.jdemo.bean.Post;
import com.jweihao.jdemo.bean.PostList;
import com.jweihao.jdemo.bean.Song;
import com.jweihao.jdemo.ui.activity.md.viewBinder.CategoryViewBinder;
import com.jweihao.jdemo.ui.activity.md.viewBinder.HorizontalItemViewBinder;
import com.jweihao.jdemo.ui.activity.md.viewBinder.SongViewBinder;
import com.wh.customcontrol.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class RecyclerViewMultiTypeActivity extends AppCompatActivity {


    @BindView(R.id.list)
    RecyclerView mRecyclerView;
    private MultiTypeAdapter mTypeAdapter;
    private Items            mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_multi_type);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mTypeAdapter = new MultiTypeAdapter();

        /* 注册类型和View的对应关系 */
        mTypeAdapter.register(Category.class, new CategoryViewBinder());
        mTypeAdapter.register(Song.class, new SongViewBinder());
        mTypeAdapter.register(PostList.class, new HorizontalItemViewBinder());
        mRecyclerView.setAdapter(mTypeAdapter);

        /* 模拟加载数据，也可以稍后再加载，然后使用
         * mTypeAdapter.notifyDataSetChanged(); 刷新列表 */
        mItems = new Items();
        List<Post> posts = new ArrayList();


        for (int i = 0; i < 30; i++) {
            mItems.add(new Category("天青色等烟雨，而我在等你。"));
            mItems.add(new Song("Android", R.drawable.ic_launcher));
            mItems.add(new Song("IOS", R.mipmap.ic_launcher_round));

//            mItems.add(new PostList(new Post(R.drawable.ic_launcher, "机器人"), 1));
            posts.add(new Post(R.mipmap.ic_launcher_round, "机器人"));
        }
        mItems.add(2,new PostList(posts));
        mTypeAdapter.setItems(mItems);
        mTypeAdapter.notifyDataSetChanged();
    }
}
