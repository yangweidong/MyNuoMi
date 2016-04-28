package com.onenews.api;

import java.util.List;

/**
 * Created by yangweidong on 16/4/27.
 */
public class SharChdeals {
    private int total;

    private List<DealsEntity> deals;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDeals(List<DealsEntity> deals) {
        this.deals = deals;
    }

    public int getTotal() {
        return total;
    }

    public List<DealsEntity> getDeals() {
        return deals;
    }

    public static class DealsEntity {
        private String deal_id;
        private String image;
        private String tiny_image;
        private String title;
        private String min_title;
        private String description;
        private int market_price;
        private int current_price;
        private int promotion_price;
        private int sale_num;
        private double score;
        private int comment_num;
        private int publish_time;
        private int purchase_deadline;
        private boolean is_reservation_required;
        private int distance;
        private int shop_num;
        private String deal_url;
        private String deal_murl;
        /**
         * shop_id : 1385571
         * longitude : 116.360396
         * latitude : 40.014293
         * distance : -1
         * shop_url : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1385571
         * shop_murl : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1385571
         */

        private List<ShopsEntity> shops;

        public void setDeal_id(String deal_id) {
            this.deal_id = deal_id;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setTiny_image(String tiny_image) {
            this.tiny_image = tiny_image;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setMin_title(String min_title) {
            this.min_title = min_title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setMarket_price(int market_price) {
            this.market_price = market_price;
        }

        public void setCurrent_price(int current_price) {
            this.current_price = current_price;
        }

        public void setPromotion_price(int promotion_price) {
            this.promotion_price = promotion_price;
        }

        public void setSale_num(int sale_num) {
            this.sale_num = sale_num;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public void setPublish_time(int publish_time) {
            this.publish_time = publish_time;
        }

        public void setPurchase_deadline(int purchase_deadline) {
            this.purchase_deadline = purchase_deadline;
        }

        public void setIs_reservation_required(boolean is_reservation_required) {
            this.is_reservation_required = is_reservation_required;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setShop_num(int shop_num) {
            this.shop_num = shop_num;
        }

        public void setDeal_url(String deal_url) {
            this.deal_url = deal_url;
        }

        public void setDeal_murl(String deal_murl) {
            this.deal_murl = deal_murl;
        }

        public void setShops(List<ShopsEntity> shops) {
            this.shops = shops;
        }

        public String getDeal_id() {
            return deal_id;
        }

        public String getImage() {
            return image;
        }

        public String getTiny_image() {
            return tiny_image;
        }

        public String getTitle() {
            return title;
        }

        public String getMin_title() {
            return min_title;
        }

        public String getDescription() {
            return description;
        }

        public int getMarket_price() {
            return market_price;
        }

        public int getCurrent_price() {
            return current_price;
        }

        public int getPromotion_price() {
            return promotion_price;
        }

        public int getSale_num() {
            return sale_num;
        }

        public double getScore() {
            return score;
        }

        public int getComment_num() {
            return comment_num;
        }

        public int getPublish_time() {
            return publish_time;
        }

        public int getPurchase_deadline() {
            return purchase_deadline;
        }

        public boolean isIs_reservation_required() {
            return is_reservation_required;
        }

        public int getDistance() {
            return distance;
        }

        public int getShop_num() {
            return shop_num;
        }

        public String getDeal_url() {
            return deal_url;
        }

        public String getDeal_murl() {
            return deal_murl;
        }

        public List<ShopsEntity> getShops() {
            return shops;
        }

        public static class ShopsEntity {
            private int shop_id;
            private double longitude;
            private double latitude;
            private int distance;
            private String shop_url;
            private String shop_murl;

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public void setShop_url(String shop_url) {
                this.shop_url = shop_url;
            }

            public void setShop_murl(String shop_murl) {
                this.shop_murl = shop_murl;
            }

            public int getShop_id() {
                return shop_id;
            }

            public double getLongitude() {
                return longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public int getDistance() {
                return distance;
            }

            public String getShop_url() {
                return shop_url;
            }

            public String getShop_murl() {
                return shop_murl;
            }

            @Override
            public String toString() {
                return "ShopsEntity{" +
                        "shop_id=" + shop_id +
                        ", longitude=" + longitude +
                        ", latitude=" + latitude +
                        ", distance=" + distance +
                        ", shop_url='" + shop_url + '\'' +
                        ", shop_murl='" + shop_murl + '\'' +
                        '}';
            }
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
                    ", publish_time=" + publish_time +
                    ", purchase_deadline=" + purchase_deadline +
                    ", is_reservation_required=" + is_reservation_required +
                    ", distance=" + distance +
                    ", shop_num=" + shop_num +
                    ", deal_url='" + deal_url + '\'' +
                    ", deal_murl='" + deal_murl + '\'' +
                    ", shops=" + shops +
                    '}';
        }
    }
}
