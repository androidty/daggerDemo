package com.ty.dagger.daggerdemo.mvp.wallet.huobi.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ty on 2018/4/28.
 */

public class HuoBiAccount {


    /**
     * status : ok
     * err-code : null
     * err-msg : null
     * data : [{"id":1249364,"type":"spot","state":"working","userid":0}]
     */

    private String status;
    @SerializedName("err-code")
    private Object errcode;
    @SerializedName("err-msg")
    private Object errmsg;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getErrcode() {
        return errcode;
    }

    public void setErrcode(Object errcode) {
        this.errcode = errcode;
    }

    public Object getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(Object errmsg) {
        this.errmsg = errmsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1249364
         * type : spot
         * state : working
         * userid : 0
         */

        private int id;
        private String type;
        private String state;
        private int userid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }
    }
}
