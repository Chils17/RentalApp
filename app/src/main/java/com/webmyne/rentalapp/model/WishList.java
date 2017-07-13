package com.webmyne.rentalapp.model;

import java.io.Serializable;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class WishList implements Serializable{

    private int  bookImage;
    private String bookName, bookPrice, bookAuthor;


    public WishList(int bookImage, String bookName, String bookPrice, String bookAuthor) {
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
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


}
