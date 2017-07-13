package com.webmyne.rentalapp.model;

/**
 * Created by chiragpatel on 11-07-2017.
 */

public class Product {
    private int img;
    private String name;
    private String author;
    private String price;
    private float rating;

    public Product(int img, String name, String author, String price, float rating) {
        this.img = img;
        this.name = name;
        this.author = author;
        this.price = price;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
