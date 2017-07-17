package com.webmyne.rentalapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.MyCartAdapter;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.MyCart;

import java.util.ArrayList;

/**
 * Created by chintans on 14-07-2017.
 */

public class CheckoutOrderActivity extends AppCompatActivity {
    RecyclerView rvMyCart;
    private ArrayList<MyCart> myCartList;
    private MyCartAdapter adapter;
    private Toolbar toolbar;
    private TfTextView txtTitle;
    private TfButton btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        txtTitle.setText(R.string.check_out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        initRecyclerView();

        actionListener();

    }

    private void init() {
        rvMyCart = (RecyclerView) findViewById(R.id.rvMyCart);
        btnConfirm = (TfButton) findViewById(R.id.btnConfirm);
    }

    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(getApplicationContext(),OrderSuccessfullActivity.class);
                finish();
            }
        });
    }

    private void initRecyclerView() {
        rvMyCart.setLayoutManager(new LinearLayoutManager(this));
        myCartList = new ArrayList<>();
        myCartList.add(new MyCart(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 500", 2));
        myCartList.add(new MyCart(R.drawable.image1, "Infinite of Cloud", "J. K. Rowling", "₹ 2000", 3));
        myCartList.add(new MyCart(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", 4));
        myCartList.add(new MyCart(R.drawable.image1, "MyCart Launch Secrets", "J. K. Rowling", "₹ 2500", 5));
        myCartList.add(new MyCart(R.drawable.image1, "Forte", "J. K. Rowling", "₹ 500", 5));
        myCartList.add(new MyCart(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 2050", 4));
        myCartList.add(new MyCart(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", 3));
        myCartList.add(new MyCart(R.drawable.image1, "Product Launch Secret", "J. K. Rowling", "₹ 2500", 2));
        adapter = new MyCartAdapter(this, myCartList);
        rvMyCart.setAdapter(adapter);
    }
}
