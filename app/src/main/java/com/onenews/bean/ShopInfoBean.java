package com.onenews.bean;

import com.onenews.test.ChildItem;

/**
 * Created by yangweidong on 16/1/11.
 */
public class ShopInfoBean extends ChildItem {

    /**
     * errno : 0
     * msg : success
     * shop : {"shop_id":753406,"city_id":100010000,"shop_name":"味多美(地安门店)","shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F753406","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F753406","address":"北京市东城区地安门东大街(地税局朝阳门税务所旁)","district_id":394,"bizarea_id":0,"phone":"01064072665","open_time":"","longitude":116.4096,"latitude":39.941,"baidu_longitude":116.4156,"baidu_latitude":39.9473,"traffic_info":"","update_time":1449123982}
     */

    private int errno;
    private String msg;
    /**
     * shop_id : 753406
     * city_id : 100010000
     * shop_name : 味多美(地安门店)
     * shop_url : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F753406
     * shop_murl : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F753406
     * address : 北京市东城区地安门东大街(地税局朝阳门税务所旁)
     * district_id : 394
     * bizarea_id : 0
     * phone : 01064072665
     * open_time :
     * longitude : 116.4096
     * latitude : 39.941
     * baidu_longitude : 116.4156
     * baidu_latitude : 39.9473
     * traffic_info :
     * update_time : 1449123982
     */

    private ShopEntity shop;

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    public int getErrno() {
        return errno;
    }

    public String getMsg() {
        return msg;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public static class ShopEntity {
        private int shop_id;
        private int city_id;
        private String shop_name;
        private String shop_url;
        private String shop_murl;
        private String address;
        private int district_id;
        private int bizarea_id;
        private String phone;
        private String open_time;
        private double longitude;
        private double latitude;
        private double baidu_longitude;
        private double baidu_latitude;
        private String traffic_info;
        private int update_time;

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public void setShop_url(String shop_url) {
            this.shop_url = shop_url;
        }

        public void setShop_murl(String shop_murl) {
            this.shop_murl = shop_murl;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setDistrict_id(int district_id) {
            this.district_id = district_id;
        }

        public void setBizarea_id(int bizarea_id) {
            this.bizarea_id = bizarea_id;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setOpen_time(String open_time) {
            this.open_time = open_time;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setBaidu_longitude(double baidu_longitude) {
            this.baidu_longitude = baidu_longitude;
        }

        public void setBaidu_latitude(double baidu_latitude) {
            this.baidu_latitude = baidu_latitude;
        }

        public void setTraffic_info(String traffic_info) {
            this.traffic_info = traffic_info;
        }

        public void setUpdate_time(int update_time) {
            this.update_time = update_time;
        }

        public int getShop_id() {
            return shop_id;
        }

        public int getCity_id() {
            return city_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public String getShop_url() {
            return shop_url;
        }

        public String getShop_murl() {
            return shop_murl;
        }

        public String getAddress() {
            return address;
        }

        public int getDistrict_id() {
            return district_id;
        }

        public int getBizarea_id() {
            return bizarea_id;
        }

        public String getPhone() {
            return phone;
        }

        public String getOpen_time() {
            return open_time;
        }

        public double getLongitude() {
            return longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getBaidu_longitude() {
            return baidu_longitude;
        }

        public double getBaidu_latitude() {
            return baidu_latitude;
        }

        public String getTraffic_info() {
            return traffic_info;
        }

        public int getUpdate_time() {
            return update_time;
        }
    }
}
