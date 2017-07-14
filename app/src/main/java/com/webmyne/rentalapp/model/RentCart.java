package com.webmyne.rentalapp.model;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class RentCart {
    private int image;
    private String name;
    private String cate;
    private String available;
    private String rtn;

    public RentCart(int image, String name, String cate, String available, String rtn) {
        this.image = image;
        this.name = name;
        this.cate = cate;
        this.available = available;
        this.rtn = rtn;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn;
    }
}
