package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.TabMenuAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.fragment.MyCartFragment;
import com.webmyne.rentalapp.fragment.RentalCartFragment;

/**
 * Created by chintans on 18-07-2017.
 */

public class ShippingBillingAddrssActivity extends AppCompatActivity {
    public ViewPager pageraddress;
    public TabLayout tabsaddress;
    private TabMenuAdapter tabMenuAdapter;
    public Context context;
    private Toolbar toolbar;
    private TfTextView txtTitle;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_billing_address);
        init();
        initToolbar();
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
        setupViewPager(pageraddress);
        tabsaddress.setupWithViewPager(pageraddress);
        highLightCurrentTab(0);
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
        tabMenuAdapter.addFragment(new MyCartFragment(), getString(R.string.billing_address));
        tabMenuAdapter.addFragment(new RentalCartFragment(), getString(R.string.shipping_address));
        pageraddress.setAdapter(tabMenuAdapter);
    }


}
