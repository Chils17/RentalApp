package com.webmyne.rentalapp.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.OrderHDetailAdapter;
import com.webmyne.rentalapp.adapter.ShopHistoryAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.OrderDetail;
import com.webmyne.rentalapp.model.OrderHistory;

import java.util.ArrayList;

public class OrderHDetailActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TfTextView txtTitle;
    private RecyclerView rvOrderDetail;
    private TfTextView emptyView;
    private ArrayList<OrderHistory> orderHistories;
    private OrderHDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_hdetail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);
        toolbar.setTitleTextColor(Color.WHITE);
        txtTitle.setText(R.string.order_history_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        actionListener();

        initRecyclerView();
    }

    private void init() {
        rvOrderDetail = (RecyclerView) findViewById(R.id.rvOrderDetail);
        emptyView = (TfTextView) findViewById(R.id.emptyView);
    }

    private void initRecyclerView() {
        rvOrderDetail.setLayoutManager(new LinearLayoutManager(this));

        orderHistories = new ArrayList<>();

        orderHistories.add(new OrderHistory(R.drawable.book1, "Killing Hemingway", "₹1000", "Brian D. Meeks", "Age 1 to 5", "12 Aug, 2015"));
        orderHistories.add(new OrderHistory(R.drawable.book1, "Infinity", "₹500", "Jenny Smith", "Age 6 to 10", "15 Aug, 2015"));
        orderHistories.add(new OrderHistory(R.drawable.book1, "Connection Culture", "₹400", "ason Pankau", "Age 11 to 15", "15 June, 2015"));
        orderHistories.add(new OrderHistory(R.drawable.book1, "Product Lunch", "₹200", "Tom Weaver", "Age 15 to 20", "23 June, 2015"));
        orderHistories.add(new OrderHistory(R.drawable.book1, "Data Capture", "₹1500", "Forte", "Age 25 to 30", "07 June, 2015"));

        adapter = new OrderHDetailAdapter(getApplicationContext(), orderHistories);
        rvOrderDetail.setAdapter(adapter);
    }

    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
