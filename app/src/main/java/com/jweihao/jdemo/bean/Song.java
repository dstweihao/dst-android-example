package com.jweihao.jdemo.bean;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/25 0025 21:42
 */

public class Song {
    private String name;
    private int image;

    public Song(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
