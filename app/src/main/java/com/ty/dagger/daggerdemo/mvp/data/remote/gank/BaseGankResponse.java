package com.ty.dagger.daggerdemo.mvp.data.remote.gank;

import java.io.Serializable;

/**
 * Created by ty on 2017/12/29.
 */

public class BaseGankResponse<T> implements Serializable {
    private boolean error;
    private T result;

    public BaseGankResponse(boolean error, T result) {
        this.error = error;
        this.result = result;
    }

    public BaseGankResponse() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseGankResponse{" +
                "error=" + error +
                ", result=" + result +
                '}';
    }
}
