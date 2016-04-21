package com.onenews.bean;

/**
 * Created by yangweidong on 16/1/27.
 */
public class OrderDetailsImageBean {
    String imageUrl;
    String details;

    public OrderDetailsImageBean(String details, String imageUrl) {
        this.details = details;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
