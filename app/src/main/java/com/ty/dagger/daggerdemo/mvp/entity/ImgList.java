package com.ty.dagger.daggerdemo.mvp.entity;

import java.io.Serializable;

/**
 * Created by ty on 2018/4/18.
 */

public class ImgList implements Serializable {
    int id;
    String url;

    public ImgList(int id, String url, int num, int count) {
        this.id = id;
        this.url = url;
        this.num = num;
        this.count = count;
    }

    public ImgList(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int num;
    int count;

}
