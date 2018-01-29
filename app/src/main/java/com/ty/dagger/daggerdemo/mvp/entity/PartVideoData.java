package com.ty.dagger.daggerdemo.mvp.entity;

import java.util.List;

/**
 * Created by ty on 2017/12/29.
 */

public class PartVideoData {
    /**
     * cmd : part_video
     * data : {"video_url":"http://test-android.oss-cn-shenzhen.aliyuncs.com/video/111.mp4",
     * "img_top_interval_time":4,"img_bottom_interval_time":7,"img_top_urls":["http://ozi86mlyf.bkt.clouddn
     * .com/1.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513836066077&di
     * =c641922bc0768938a0f8960107fd1b0f&imgtype=0&src=http%3A%2F%2Fpic36.photophoto
     * .cn%2F20150713%2F0039038513606479_b.jpg","https://ss0.bdstatic
     * .com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4211301764,2334420320&fm=27&gp=0.jpg"],
     * "img_bottom_urls":["http://ozi86mlyf.bkt.clouddn.com/2.jpg","https://ss0.bdstatic
     * .com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1929173052,1159541214&fm=27&gp=0.jpg","http://pic4.nipic
     * .com/20091121/3764872_215617048242_2.jpg"]}
     */

    private String cmd;
    private DataBean data;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * video_url : http://test-android.oss-cn-shenzhen.aliyuncs.com/video/111.mp4
         * img_top_interval_time : 4
         * img_bottom_interval_time : 7
         * img_top_urls : ["http://ozi86mlyf.bkt.clouddn.com/1.jpg","https://timgsa.baidu
         * .com/timg?image&quality=80&size=b9999_10000&sec=1513836066077&di
         * =c641922bc0768938a0f8960107fd1b0f&imgtype=0&src=http%3A%2F%2Fpic36.photophoto
         * .cn%2F20150713%2F0039038513606479_b.jpg","https://ss0.bdstatic
         * .com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4211301764,2334420320&fm=27&gp=0.jpg"]
         * img_bottom_urls : ["http://ozi86mlyf.bkt.clouddn.com/2.jpg","https://ss0.bdstatic
         * .com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1929173052,1159541214&fm=27&gp=0.jpg","http://pic4.nipic
         * .com/20091121/3764872_215617048242_2.jpg"]
         */

        private String video_url;
        private int img_top_interval_time;
        private int img_bottom_interval_time;
        private List<String> img_top_urls;
        private List<String> img_bottom_urls;

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public int getImg_top_interval_time() {
            return img_top_interval_time;
        }

        public void setImg_top_interval_time(int img_top_interval_time) {
            this.img_top_interval_time = img_top_interval_time;
        }

        public int getImg_bottom_interval_time() {
            return img_bottom_interval_time;
        }

        public void setImg_bottom_interval_time(int img_bottom_interval_time) {
            this.img_bottom_interval_time = img_bottom_interval_time;
        }

        public List<String> getImg_top_urls() {
            return img_top_urls;
        }

        public void setImg_top_urls(List<String> img_top_urls) {
            this.img_top_urls = img_top_urls;
        }

        public List<String> getImg_bottom_urls() {
            return img_bottom_urls;
        }

        public void setImg_bottom_urls(List<String> img_bottom_urls) {
            this.img_bottom_urls = img_bottom_urls;
        }
    }
}
