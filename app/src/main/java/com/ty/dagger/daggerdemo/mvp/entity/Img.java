package com.ty.dagger.daggerdemo.mvp.entity;

import java.io.Serializable;

/**
 * Created by ty on 2018/4/3.
 */

public class Img implements Serializable{
    private int id;
    private String url;

    public Img() {
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
}
