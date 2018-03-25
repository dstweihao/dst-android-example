package com.jweihao.jdemo.bean;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/25 0025 22:56
 */

public class Post {
    private int    image;
    private String name;

    public Post(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
