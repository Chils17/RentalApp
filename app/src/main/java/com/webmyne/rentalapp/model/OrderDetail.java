package com.webmyne.rentalapp.model;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class OrderDetail {
    private int id;
    private String name;
    private String date;
    private String price;
    private String book_no;

    public OrderDetail(int id, String name, String date, String price, String book_no) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
        this.book_no = book_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook_no() {
        return book_no;
    }

    public void setBook_no(String book_no) {
        this.book_no = book_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
