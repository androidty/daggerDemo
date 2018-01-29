package com.ty.dagger.daggerdemo.mvp.entity;

import java.util.List;

/**
 * Created by ty on 2017/12/29.
 */

public class Product {

    /**
     * success : true
     * data : {"zeroYearsOldDays":28,"products":[{"type":8,"productID":["17"],"absName":"ZTVI",
     * "sologan":"百万大病医疗互助 标准版","desc":"全面覆盖188种疾病和第二次恶性肿瘤","productIcon":"https://static.weixingongchang
     * .com/img/wx3/product/icons/icon_17_w.png","productLogo":"https://static.weixingongchang
     * .com/img/wx3/product/banners/prod_17_m.jpg","nodes":[0,18,65,75],"joinNode":["0","65"],
     * "planNode":["0","100"],"notice":"预存#40元#，最高可获得#300万元#互助金","btn":{"text":"升级加入"}},{"type":2,
     * "productID":[1],"absName":"ZT1H","sologan":"百万大病医疗互助 基础版","desc":"全面覆盖癌症及常见大病189种",
     * "productIcon":"https://static.weixingongchang.com/img/wx3/product/icons/icon_0_w.png",
     * "productLogo":"https://static.weixingongchang.com/img/wx3/product/banners/prod_0_m.jpg","nodes":[0,
     * 18,65,75],"joinNode":[0,65],"planNode":[0,75],"notice":"预存#10元#，最高可获得#40万元#互助金",
     * "btn":{"text":"立即加入"}},{"type":2,"productID":["2"],"absName":"ZT2H","sologan":"出行意外互助",
     * "desc":"长期保障，出行无忧","productIcon":"https://static.weixingongchang.com/img/wx3/product/icons/icon_2_w
     * .png","productLogo":"https://static.weixingongchang.com/img/wx3/product/banners/prod_2_m.jpg",
     * "nodes":[0,18,65,75],"joinNode":["0","65"],"planNode":["0","65"],"notice":"预存#10元#，最高可获得#10万元#互助金",
     * "btn":{"text":"立即加入"}},{"type":4,"productID":["13"],"absName":"YCZL","sologan":"名医直通车",
     * "desc":"名医直通车是由50家三甲医院和众托帮平台共同发起的一项专为众托帮会员提供的名医会诊服务。","productIcon":"https://static.weixingongchang
     * .com/img/wx3/product/icons/icon_13_w.png","productLogo":"https://static.weixingongchang
     * .com/img/wx3/product/banners/prod_13_m.jpg","nodes":[0,18,65,75],"joinNode":["0","1000"],
     * "planNode":["0","1000"],"notice":"名医直通车是由50家三甲医院和众托帮平台共同发起的一项专为众托帮会员提供的名医会诊服务。",
     * "btn":{"text":"查看"}},{"type":4,"productID":["14"],"absName":"ZYFW","sologan":"住院应急金服务",
     * "desc":"众托帮大病医疗互助计划会员专属福利。","productIcon":"https://static.weixingongchang
     * .com/img/wx3/product/icons/icon_14_w.png","productLogo":"https://static.weixingongchang
     * .com/img/wx3/product/banners/prod_14_m.jpg","nodes":[0,18,65,75],"joinNode":["0","75"],
     * "planNode":["0","1000"],"notice":"众托帮大病医疗互助计划会员专属福利。","btn":{"text":"查看"}},{"type":9,
     * "productID":[0],"absName":"JGDZ","sologan":"机构定制","desc":"根据行业、行业协会、特定人群的需求，量身定制合适的互助计划。",
     * "productIcon":"https://static.weixingongchang.com/img/wx3/product/icons/icon_custom_h.png",
     * "productLogo":"https://static.weixingongchang.com/img/wx3/product/banners/prod_0_m.jpg","nodes":[0,
     * 0,0,0],"joinNode":[0,0],"planNode":[0,0],"notice":"","btn":{"text":"立即申请"}}]}
     * message :
     */

    private boolean success;
    private DataBean data;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {


        private int zeroYearsOldDays;
        private List<ProductsBean> products;

        public int getZeroYearsOldDays() {
            return zeroYearsOldDays;
        }

        public void setZeroYearsOldDays(int zeroYearsOldDays) {
            this.zeroYearsOldDays = zeroYearsOldDays;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * type : 8
             * productID : ["17"]
             * absName : ZTVI
             * sologan : 百万大病医疗互助 标准版
             * desc : 全面覆盖188种疾病和第二次恶性肿瘤
             * productIcon : https://static.weixingongchang.com/img/wx3/product/icons/icon_17_w.png
             * productLogo : https://static.weixingongchang.com/img/wx3/product/banners/prod_17_m.jpg
             * nodes : [0,18,65,75]
             * joinNode : ["0","65"]
             * planNode : ["0","100"]
             * notice : 预存#40元#，最高可获得#300万元#互助金
             * btn : {"text":"升级加入"}
             */

            private int type;
            private String absName;
            private String sologan;
            private String desc;
            private String productIcon;
            private String productLogo;
            private String notice;
            private BtnBean btn;
            private List<String> productID;
            private List<Integer> nodes;
            private List<String> joinNode;
            private List<String> planNode;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getAbsName() {
                return absName;
            }

            public void setAbsName(String absName) {
                this.absName = absName;
            }

            public String getSologan() {
                return sologan;
            }

            public void setSologan(String sologan) {
                this.sologan = sologan;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getProductIcon() {
                return productIcon;
            }

            public void setProductIcon(String productIcon) {
                this.productIcon = productIcon;
            }

            public String getProductLogo() {
                return productLogo;
            }

            public void setProductLogo(String productLogo) {
                this.productLogo = productLogo;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            public BtnBean getBtn() {
                return btn;
            }

            public void setBtn(BtnBean btn) {
                this.btn = btn;
            }

            public List<String> getProductID() {
                return productID;
            }

            public void setProductID(List<String> productID) {
                this.productID = productID;
            }

            public List<Integer> getNodes() {
                return nodes;
            }

            public void setNodes(List<Integer> nodes) {
                this.nodes = nodes;
            }

            public List<String> getJoinNode() {
                return joinNode;
            }

            public void setJoinNode(List<String> joinNode) {
                this.joinNode = joinNode;
            }

            public List<String> getPlanNode() {
                return planNode;
            }

            public void setPlanNode(List<String> planNode) {
                this.planNode = planNode;
            }

            public static class BtnBean {
                /**
                 * text : 升级加入
                 */

                private String text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }
}
