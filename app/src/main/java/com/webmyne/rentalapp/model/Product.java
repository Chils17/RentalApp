package com.webmyne.rentalapp.model;

/**
 * Created by chiragpatel on 11-07-2017.
 */

public class Product {
    private int img;
    private String name;
    private String author;
    private String price;
    private String rating;
    private String review;

    public Product(int img, String name, String author, String price, String rating, String review) {
        this.img = img;
        this.name = name;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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
