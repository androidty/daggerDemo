package com.ty.dagger.daggerdemo.mvp.wallet.huobi.entity;

/**
 * Created by ty on 2018/5/3.
 */

public class HuoBiBalance {
    /**
     * currency : ht
     * type : trade
     * balance : 0.000000000000000000
     */

    private String currency;
    private String type;
    private String balance;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
