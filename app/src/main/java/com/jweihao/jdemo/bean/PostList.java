package com.jweihao.jdemo.bean;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/25 0025 22:54
 */

import java.util.List;

import me.drakeet.multitype.Items;

public class PostList {
    public final List<Post> mPostList;

    public List<Post> getPostList() {
        return mPostList;
    }

    public PostList(List<Post> postList) {

        mPostList = postList;
    }
}
