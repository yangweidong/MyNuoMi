package com.onenews.bean;

import com.onenews.test.ChildItem;

/**
 * Created by yangweidong on 16/1/11.
 */
public class ShopInfoBean extends ChildItem {

    /**
     * city_id : 100010000
     * shop_id : 109291
     * shop_url : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F109291
     * shop_murl : http://www.nuomi.com/cps/redirect?cid=openapi&app_id=e1e625de7a0eedd4c91cb1b7ab48e4c9&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F109291
     * name : 顺峰(方庄店)
     * address : 北京市丰台区方庄路5-2
     * phone : 01067676368
     * longitude : 116.4446
     * latitude : 39.8719
     */

    private int city_id;
    private int shop_id;
    private String shop_url;
    private String shop_murl;
    private String name;
    private String address;
    private String phone;
    private double longitude;
    private double latitude;

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public void setShop_murl(String shop_murl) {
        this.shop_murl = shop_murl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getCity_id() {
        return city_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public String getShop_url() {
        return shop_url;
    }

    public String getShop_murl() {
        return shop_murl;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
