package com.webmyne.rentalapp.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.TabMenuAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.fragment.MyCartFragment;
import com.webmyne.rentalapp.fragment.RentalCartFragment;

public class CartActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TfTextView txtTitle;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private TabMenuAdapter tabMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        txtTitle.setText(R.string.cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        actionListener();

    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        highLightCurrentTab(0);
    }

    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    private void setupViewPager(ViewPager viewPager) {
        tabMenuAdapter = new TabMenuAdapter(getSupportFragmentManager(), this);
        tabMenuAdapter.addFragment(new MyCartFragment(), getString(R.string.my_cart));
        tabMenuAdapter.addFragment(new RentalCartFragment(), getString(R.string.rental_cart));
        viewPager.setAdapter(tabMenuAdapter);
    }

    private void highLightCurrentTab(int position) {

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(null);
            tab.setCustomView(tabMenuAdapter.getTabView(i));
        }

        TabLayout.Tab tab = tabLayout.getTabAt(position);
        tab.setCustomView(null);
        tab.setCustomView(tabMenuAdapter.getSelectedTabView(position));

    }
}
