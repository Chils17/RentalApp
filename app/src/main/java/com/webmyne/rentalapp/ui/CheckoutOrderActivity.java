package com.webmyne.rentalapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

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
    private ArrayList<MyCart> myCartList;
    private MyCartAdapter adapter;
    private Toolbar toolbar;
    private TfTextView txtTitle;
    private TfButton btnConfirm;
    private LinearLayout ll_cart_content, ll_cart_content_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        initToolbar();
        init();
        inflateCartData();
        actionListener();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);
        setSupportActionBar(toolbar);
        txtTitle.setText(getResources().getString(R.string.check_out));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void init() {
        ll_cart_content = (LinearLayout) findViewById(R.id.ll_cart_content);
        ll_cart_content_parent = (LinearLayout) findViewById(R.id.ll_cart_content_parent);
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
                Functions.fireIntent(getApplicationContext(), OrderSuccessfullActivity.class);
                finish();
            }
        });
    }

    private void inflateCartData() {
        for (int i = 0; i < 10; i++) {
            View hiddenInfo = this.getLayoutInflater().inflate(R.layout.cart_item, ll_cart_content, false);
            ll_cart_content_parent.addView(hiddenInfo);
        }
    }
}
