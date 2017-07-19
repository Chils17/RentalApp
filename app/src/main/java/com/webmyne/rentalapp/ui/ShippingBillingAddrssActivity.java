package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.TabMenuAdapter;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.fragment.BillingAddressFragment;
import com.webmyne.rentalapp.fragment.ShippingAddressFragment;
import com.webmyne.rentalapp.helper.UIHelper;

/**
 * Created by chintans on 18-07-2017.
 */

public class ShippingBillingAddrssActivity extends AppCompatActivity {
    public ViewPager pageraddress;
    public TabLayout tabsaddress;
    private TabMenuAdapter tabMenuAdapter;
    private TfButton btnSaveAddress;
    public Context context;
    private Toolbar toolbar;
    private TfTextView txtTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_billing_address);
        init();
        initToolbar();
        actionListener();
    }

    private void actionListener() {
        pageraddress.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        txtTitle.setText(R.string.address);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void init() {
        pageraddress = (ViewPager) findViewById(R.id.pager_address);
        tabsaddress = (TabLayout) findViewById(R.id.tabs_address);
        btnSaveAddress = (TfButton) findViewById(R.id.btnSaveAddress);
        setupViewPager(pageraddress);
        tabsaddress.setupWithViewPager(pageraddress);
        highLightCurrentTab(0);
        btnSaveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(ShippingAddressFragment.edtaddressshippingbilling.getText().toString())) {
                    UIHelper.showMessage(ShippingBillingAddrssActivity.this, "Please enter shipping adresss.");
                }else if(TextUtils.isEmpty(BillingAddressFragment.edtaddressshippingbilling.getText().toString())){
                    UIHelper.showMessage(ShippingBillingAddrssActivity.this, "Please enter billing adresss.");
                }
                else {
                    Functions.fireIntent(ShippingBillingAddrssActivity.this, CheckoutOrderActivity.class);
                    finish();
                }
            }
        });
    }
    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabsaddress.getTabCount(); i++) {
            TabLayout.Tab tab = tabsaddress.getTabAt(i);
            tab.setCustomView(null);
            tab.setCustomView(tabMenuAdapter.getTabView(i));
        }

        TabLayout.Tab tab = tabsaddress.getTabAt(position);
        tab.setCustomView(null);
        tab.setCustomView(tabMenuAdapter.getSelectedTabView(position));
    }

    private void setupViewPager(ViewPager pageraddress) {
        tabMenuAdapter = new TabMenuAdapter(getSupportFragmentManager(), this);
        tabMenuAdapter.addFragment(new ShippingAddressFragment(), "Shipping Address");
        tabMenuAdapter.addFragment(new BillingAddressFragment(), "Billing Address");
        pageraddress.setAdapter(tabMenuAdapter);
    }


}
