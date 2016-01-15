package com.onenews.bean;

import java.util.List;

/**
 * Created by yangweidong on 16/1/12.
 */
public class HomeShop {

    /**
     * errno : 0
     * msg : success
     * data : {"total":10,"shops":[{"shop_id":114733,"shop_name":"俏江南(东方广场店)","longitude":116.423197,"latitude":39.915299,"distance":360.05102081407,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F114733","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F114733","deals":[]},{"shop_id":110450,"shop_name":"俏江南(恒基中心店)","longitude":116.434695,"latitude":39.913597,"distance":1357.5146250837,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F110450","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F110450","deals":[]},{"shop_id":1375002,"shop_name":"俏江南(丰联广场店)","longitude":116.444693,"latitude":39.929797,"distance":2701.1635573793,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1375002","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1375002","deals":[]},{"shop_id":1375003,"shop_name":"俏江南(西单店)","longitude":116.377392,"latitude":39.916095,"distance":3548.3595654442,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1375003","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1375003","deals":[]},{"shop_id":110418,"shop_name":"俏江南(国贸中心店)","longitude":116.463791,"latitude":39.915299,"distance":3820.7870224089,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F110418","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F110418","deals":[]},{"shop_id":1375005,"shop_name":"俏江南(东方银座店)","longitude":116.441693,"latitude":39.946096,"distance":3904.7998810556,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1375005","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1375005","deals":[]},{"shop_id":114738,"shop_name":"俏江南(嘉里店)","longitude":116.466594,"latitude":39.919595,"distance":4083.8128977499,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F114738","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F114738","deals":[]},{"shop_id":502217,"shop_name":"俏江南(恒安大厦)","longitude":116.467097,"latitude":39.926297,"distance":4271.3060728315,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F502217","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F502217","deals":[]},{"shop_id":1522337,"shop_name":"俏江南(金树街店)","longitude":116.368391,"latitude":39.920999,"distance":4357.0292222522,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1522337","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1522337","deals":[]},{"shop_id":592034,"shop_name":"俏江南(Subu店)","longitude":116.368391,"latitude":39.920999,"distance":4357.0292222522,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F592034","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F592034","deals":[]}]}
     */

    private int errno;
    private String msg;
    /**
     * total : 10
     * shops : [{"shop_id":114733,"shop_name":"俏江南(东方广场店)","longitude":116.423197,"latitude":39.915299,"distance":360.05102081407,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F114733","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F114733","deals":[]},{"shop_id":110450,"shop_name":"俏江南(恒基中心店)","longitude":116.434695,"latitude":39.913597,"distance":1357.5146250837,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F110450","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F110450","deals":[]},{"shop_id":1375002,"shop_name":"俏江南(丰联广场店)","longitude":116.444693,"latitude":39.929797,"distance":2701.1635573793,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1375002","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1375002","deals":[]},{"shop_id":1375003,"shop_name":"俏江南(西单店)","longitude":116.377392,"latitude":39.916095,"distance":3548.3595654442,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1375003","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1375003","deals":[]},{"shop_id":110418,"shop_name":"俏江南(国贸中心店)","longitude":116.463791,"latitude":39.915299,"distance":3820.7870224089,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F110418","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F110418","deals":[]},{"shop_id":1375005,"shop_name":"俏江南(东方银座店)","longitude":116.441693,"latitude":39.946096,"distance":3904.7998810556,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1375005","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1375005","deals":[]},{"shop_id":114738,"shop_name":"俏江南(嘉里店)","longitude":116.466594,"latitude":39.919595,"distance":4083.8128977499,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F114738","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F114738","deals":[]},{"shop_id":502217,"shop_name":"俏江南(恒安大厦)","longitude":116.467097,"latitude":39.926297,"distance":4271.3060728315,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F502217","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F502217","deals":[]},{"shop_id":1522337,"shop_name":"俏江南(金树街店)","longitude":116.368391,"latitude":39.920999,"distance":4357.0292222522,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F1522337","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F1522337","deals":[]},{"shop_id":592034,"shop_name":"俏江南(Subu店)","longitude":116.368391,"latitude":39.920999,"distance":4357.0292222522,"deal_num":null,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F592034","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F592034","deals":[]}]
     */

    private DataEntity data;

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public String getMsg() {
        return msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        private int total;
        /**
         * shop_id : 114733
         * shop_name : 俏江南(东方广场店)
         * longitude : 116.423197
         * latitude : 39.915299
         * distance : 360.05102081407
         * deal_num : null
         * shop_url : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F114733
         * shop_murl : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F114733
         * deals : []
         */

        private List<ShopsEntity> shops;

        public void setTotal(int total) {
            this.total = total;
        }

        public void setShops(List<ShopsEntity> shops) {
            this.shops = shops;
        }

        public int getTotal() {
            return total;
        }

        public List<ShopsEntity> getShops() {
            return shops;
        }

        public static class ShopsEntity {
            private int shop_id;
            private String shop_name;
            private double longitude;
            private double latitude;
            private double distance;
            private Object deal_num;
            private String shop_url;
            private String shop_murl;
            private List<?> deals;

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public void setDeal_num(Object deal_num) {
                this.deal_num = deal_num;
            }

            public void setShop_url(String shop_url) {
                this.shop_url = shop_url;
            }

            public void setShop_murl(String shop_murl) {
                this.shop_murl = shop_murl;
            }

            public void setDeals(List<?> deals) {
                this.deals = deals;
            }

            public int getShop_id() {
                return shop_id;
            }

            public String getShop_name() {
                return shop_name;
            }

            public double getLongitude() {
                return longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public double getDistance() {
                return distance;
            }

            public Object getDeal_num() {
                return deal_num;
            }

            public String getShop_url() {
                return shop_url;
            }

            public String getShop_murl() {
                return shop_murl;
            }

            public List<?> getDeals() {
                return deals;
            }

            @Override
            public String toString() {
                return "ShopsEntity{" +
                        "shop_id=" + shop_id +
                        ", shop_name='" + shop_name + '\'' +
                        ", longitude=" + longitude +
                        ", latitude=" + latitude +
                        ", distance=" + distance +
                        ", deal_num=" + deal_num +
                        ", shop_url='" + shop_url + '\'' +
                        ", shop_murl='" + shop_murl + '\'' +
                        ", deals=" + deals +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "total=" + total +
                    ", shops=" + shops +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HomeShop{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
