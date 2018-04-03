package com.ty.dagger.daggerdemo.mvp.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ty on 2018/3/26.
 */

public class LambdaStudy {
    /**
     * ()->{}
     *
     * @param s
     */
    public void study1(String s) {
        new Thread(() -> {
            Log.d("lambdastudy", "study1:  " + s);
        }).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void study2() {
        List<String> strings = Arrays.asList("123", "sth", "sb", "234", "study");
        strings.forEach(System.out::println);
    }
}
