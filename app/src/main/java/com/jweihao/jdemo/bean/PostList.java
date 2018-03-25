package com.jweihao.jdemo.bean;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/25 0025 22:54
 */

import java.util.List;

public class PostList {
    public final List<Post> mPostList;
    public       int        currentPosition;

    public PostList(List<Post> postList, int currentPosition) {
        mPostList = postList;
        this.currentPosition = currentPosition;
    }

    public List<Post> getPostList() {
        return mPostList;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
