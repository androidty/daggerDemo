package com.ty.dagger.daggerdemo.mvp.wallet.gate.entity;

/**
 * Created by ty on 2018/5/3.
 */

public class GateBalance {

    /**
     * result : true
     * available : {"BTC":"1000","ETH":"968.8","ETC":"0"}
     * locked : {"ETH":"1"}
     */

    private String result;
    private AvailableBean available;
    private AvailableBean locked;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public AvailableBean getAvailable() {
        return available;
    }

    public void setAvailable(AvailableBean available) {
        this.available = available;
    }

    public AvailableBean getLocked() {
        return locked;
    }

    public void setLocked(AvailableBean locked) {
        this.locked = locked;
    }

    public static class AvailableBean {
        /**
         * BTC : 1000
         * ETH : 968.8
         * ETC : 0
         */

        private String BTC;
        private String ETH;
        private String ETC;

        public String getBTC() {
            return BTC;
        }

        public void setBTC(String BTC) {
            this.BTC = BTC;
        }

        public String getETH() {
            return ETH;
        }

        public void setETH(String ETH) {
            this.ETH = ETH;
        }

        public String getETC() {
            return ETC;
        }

        public void setETC(String ETC) {
            this.ETC = ETC;
        }
    }
}
