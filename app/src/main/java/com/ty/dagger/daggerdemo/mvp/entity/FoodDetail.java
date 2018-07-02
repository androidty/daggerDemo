package com.ty.dagger.daggerdemo.mvp.entity;

import java.util.List;

/**
 * Created by ty on 2018/6/29.
 */

public class FoodDetail {

    private List<BuzhouBean> buzhou;

    public List<BuzhouBean> getBuzhou() {
        return buzhou;
    }

    public void setBuzhou(List<BuzhouBean> buzhou) {
        this.buzhou = buzhou;
    }

    public static class BuzhouBean {
        /**
         * img : https://i8.meishichina.com/attachment/recipe/2018/06/20/2018062015294777149811806550.jpg?x-oss-process=style/p320
         * content : 花肉改刀。
         */

        private String img;
        private String content;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
