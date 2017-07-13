package com.webmyne.rentalapp.model;

import java.io.Serializable;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class ShopHistoryList implements Serializable{

    private int  bookImage;
    private String bookName, bookPrice, bookAuthor, bookCategories, bookDeliverTime;


    public ShopHistoryList(int bookImage, String bookName, String bookPrice, String bookAuthor, String bookCategories, String bookDeliverTime) {
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.bookCategories = bookCategories;
        this.bookDeliverTime = bookDeliverTime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookImage() {
        return bookImage;
    }

    public void setBookImage(int bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(String bookCategories) {
        this.bookCategories = bookCategories;
    }

    public String getBookDeliverTime() {
        return bookDeliverTime;
    }

    public void setBookDeliverTime(String bookDeliverTime) {
        this.bookDeliverTime = bookDeliverTime;
    }


}
