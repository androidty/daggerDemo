package com.ty.dagger.daggerdemo.mvp.utils;

/**
 * Created by ty on 2018/2/12.
 */

public class PagerData {
    int num0;
    int num1;
    int num2;
    int currentNum;
    public PagerData(){
        this(-1,-1);
    }

    public PagerData(int num0, int num1) {
       this(num0,num1,Integer.MAX_VALUE);
    }
    public PagerData(int num0,int num1,int num2){
        this.num0=num0;
        this.num1=num1;
        this.num2=num2;
    }


    public void initPagerData(int num0, int num1) {

    }

    public void insertData(int num) {
        if(num<num0){
            this.num0=num;
        }
        if(num>num2){
            this.num2= num;
        }
        this.currentNum = this.num1;
    }

    public void destroyData(int num){

    }
}
