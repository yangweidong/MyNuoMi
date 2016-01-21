package com.onenews.bean;

import java.util.List;

/**
 * Created by yangweidong on 16/1/19.
 */
public class ShopOrderListBean {


    /**
     * errno : 0
     * msg : success
     * deals : [{"deal_id":7416560,"image":"http://timg.baidu.com/timg?lbstsm&ref=http%3a%2f%2fbj.nuomi.com&quality=100&size=8&sec=1453202334&di=5e16f2de3d2404573d5e8d8522be47b1&src=http://e.hiphotos.baidu.com/bainuo/crop=0,0,720,436;w=720;q=79/sign=9ff4c51afa039245b5fabb4fbaa488f2/9213b07eca80653850ed97c491dda144ac3482e5.jpg","tiny_image":"http://timg.baidu.com/timg?lbstsm&ref=http%3a%2f%2fbj.nuomi.com&quality=100&size=8&sec=1453202334&di=3a5f82d65d01569675291dff65347568&src=http://e.hiphotos.baidu.com/bainuo/crop=0,0,720,436;w=230;q=79/sign=9fc7fae49445d688b74de8e499f2512e/9213b07eca80653850ed97c491dda144ac3482e5.jpg","title":"炙子革命","min_title":"炙子革命储值卡","description":"鼓楼店3000元储值卡！节假日通用，提供免费WiFi、停车位！","market_price":300000,"current_price":270000,"promotion_price":265000,"sale_num":0,"score":0,"comment_num":0,"deal_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fbj.nuomi.com%2Fdeal%2F1czldlki.html","deal_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fbj%2Fdeal%2F1czldlki"},{"deal_id":4683982,"image":"http://timg.baidu.com/timg?lbstsm&ref=http%3a%2f%2fbj.nuomi.com&quality=100&size=8&sec=1453202334&di=1eb4ff6ae890c90b3d55a0bdb581e17f&src=http://e.hiphotos.baidu.com/bainuo/crop=0,49,690,418;w=470;q=80/sign=cb69a90cb0003af359f58620081aea68/3801213fb80e7beca95d4ae4292eb9389b506b34.jpg","tiny_image":"http://timg.baidu.com/timg?lbstsm&ref=http%3a%2f%2fbj.nuomi.com&quality=100&size=8&sec=1453202334&di=ba6a572326a6121ab2cb727d02f96d75&src=http://e.hiphotos.baidu.com/bainuo/crop=0,49,690,418;w=230;q=80/sign=345069fb30d3d539d572558307b7c564/3801213fb80e7beca95d4ae4292eb9389b506b34.jpg","title":"炙子革命","min_title":"炙子革命100元代金券","description":"鼓楼店100元代金券！全场通用，可叠加使用，节假日通用，提供免费WiFi、停车位","market_price":10000,"current_price":9500,"promotion_price":8700,"sale_num":282,"score":4.56,"comment_num":16,"deal_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fbj.nuomi.com%2Fdeal%2Fbhu6hit0.html","deal_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fbj%2Fdeal%2Fbhu6hit0"}]
     */

    private int errno;
    private String msg;
    /**
     * deal_id : 7416560
     * image : http://timg.baidu.com/timg?lbstsm&ref=http%3a%2f%2fbj.nuomi.com&quality=100&size=8&sec=1453202334&di=5e16f2de3d2404573d5e8d8522be47b1&src=http://e.hiphotos.baidu.com/bainuo/crop=0,0,720,436;w=720;q=79/sign=9ff4c51afa039245b5fabb4fbaa488f2/9213b07eca80653850ed97c491dda144ac3482e5.jpg
     * tiny_image : http://timg.baidu.com/timg?lbstsm&ref=http%3a%2f%2fbj.nuomi.com&quality=100&size=8&sec=1453202334&di=3a5f82d65d01569675291dff65347568&src=http://e.hiphotos.baidu.com/bainuo/crop=0,0,720,436;w=230;q=79/sign=9fc7fae49445d688b74de8e499f2512e/9213b07eca80653850ed97c491dda144ac3482e5.jpg
     * title : 炙子革命
     * min_title : 炙子革命储值卡
     * description : 鼓楼店3000元储值卡！节假日通用，提供免费WiFi、停车位！
     * market_price : 300000
     * current_price : 270000
     * promotion_price : 265000
     * sale_num : 0
     * score : 0
     * comment_num : 0
     * deal_url : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fbj.nuomi.com%2Fdeal%2F1czldlki.html
     * deal_murl : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fbj%2Fdeal%2F1czldlki
     */

    private List<DealsEntity> deals;

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDeals(List<DealsEntity> deals) {
        this.deals = deals;
    }

    public int getErrno() {
        return errno;
    }

    public String getMsg() {
        return msg;
    }

    public List<DealsEntity> getDeals() {
        return deals;
    }

    public class DealsEntity {
        private int deal_id;
        private String image;
        private String tiny_image;
        private String title;
        private String min_title;
        private String description;
        private String market_price;
        private String current_price;
        private String promotion_price;
        private String sale_num;
        private String score;
        private String comment_num;
        private String deal_url;
        private String deal_murl;

        public int getDeal_id() {
            return deal_id;
        }

        public void setDeal_id(int deal_id) {
            this.deal_id = deal_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTiny_image() {
            return tiny_image;
        }

        public void setTiny_image(String tiny_image) {
            this.tiny_image = tiny_image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMin_title() {
            return min_title;
        }

        public void setMin_title(String min_title) {
            this.min_title = min_title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(String current_price) {
            this.current_price = current_price;
        }

        public String getPromotion_price() {
            return promotion_price;
        }

        public void setPromotion_price(String promotion_price) {
            this.promotion_price = promotion_price;
        }

        public String getSale_num() {
            return sale_num;
        }

        public void setSale_num(String sale_num) {
            this.sale_num = sale_num;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getComment_num() {
            return comment_num;
        }

        public void setComment_num(String comment_num) {
            this.comment_num = comment_num;
        }

        public String getDeal_url() {
            return deal_url;
        }

        public void setDeal_url(String deal_url) {
            this.deal_url = deal_url;
        }

        public String getDeal_murl() {
            return deal_murl;
        }

        public void setDeal_murl(String deal_murl) {
            this.deal_murl = deal_murl;
        }

        @Override
        public String toString() {
            return "DealsEntity{" +
                    "deal_id=" + deal_id +
                    ", image='" + image + '\'' +
                    ", tiny_image='" + tiny_image + '\'' +
                    ", title='" + title + '\'' +
                    ", min_title='" + min_title + '\'' +
                    ", description='" + description + '\'' +
                    ", market_price=" + market_price +
                    ", current_price=" + current_price +
                    ", promotion_price=" + promotion_price +
                    ", sale_num=" + sale_num +
                    ", score=" + score +
                    ", comment_num=" + comment_num +
                    ", deal_url='" + deal_url + '\'' +
                    ", deal_murl='" + deal_murl + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ShopOrderListBean{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                ", deals=" + deals +
                '}';
    }
}
