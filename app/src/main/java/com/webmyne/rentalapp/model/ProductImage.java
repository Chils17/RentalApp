package com.webmyne.rentalapp.model;

import java.io.Serializable;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class ProductImage implements Serializable {
    private int img;
    private String img_url;

    public ProductImage(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public ProductImage(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
