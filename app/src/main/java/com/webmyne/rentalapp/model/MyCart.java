package com.webmyne.rentalapp.model;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class MyCart {
    private int image;
    private String name;
    private String category;
    private String price;
    private int qty;

    public MyCart(int image, String name, String category, String price, int qty) {
        this.image = image;
        this.name = name;
        this.category = category;
        this.price = price;
        this.qty = qty;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
