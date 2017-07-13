package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.WishlistAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.WishList;

import java.util.ArrayList;

public class WishlistActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TfTextView txtTitle;
    private WishlistAdapter wishlistAdapter;
    private Context context;
    private ArrayList<WishList> wishLists;
    private RecyclerView recyclerView;

    private String[] bookName = {"Killing Hemingway","Infinity","Connection Culture","Product Lunch","Data Capture"};
    private String[] bookPrice = {"₹1000","₹500","₹750","₹200","₹100"};
    private String[] bookAuthor = {"Brian D. Meeks","Jenny Smith","Jason Pankau","Tom Weaver","Forte"};
    private Integer[] bookImage = {R.drawable.book4, R.drawable.book2, R.drawable.book5, R.drawable.book4, R.drawable.book5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        init();
    }

    private void init() {
        context  = this;
        recyclerView = (RecyclerView) findViewById(R.id.wishList_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        wishLists = new ArrayList<>();

        for (int i = 0; i < bookName.length; i++){
            wishLists.add(new WishList(
                    bookImage[i], bookName[i], bookPrice[i], bookAuthor[i]
            ));
        }
        wishlistAdapter = new WishlistAdapter(context,wishLists);
        recyclerView.setAdapter(wishlistAdapter);

        initToolbar();
    }



    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) toolbar.findViewById(R.id.txtTitle);
        toolbar.setTitle("");

        txtTitle.setText(R.string.wish_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
