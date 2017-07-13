package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.ViewPagerAdapter;
import com.webmyne.rentalapp.custom.TfTextView;

public class OrderhistoryActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Context context;

    private Toolbar toolbar;
    private TfTextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderhistorytab);

        init();
    }

    private void init() {
        context = this;
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), context);
        tabLayout.setupWithViewPager(viewPager);
        createViewPager(viewPager);
        highLightCurrentTab(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        initToolbar();

    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(null);
            tab.setCustomView(viewPagerAdapter.getTabView(i));
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        tab.setCustomView(null);
        tab.setCustomView(viewPagerAdapter.getSelectedTabView(position));
    }

    private void createViewPager(ViewPager viewPager) {
        viewPagerAdapter.addFrag(new ShopTabHistory(),"Shop History");
        viewPagerAdapter.addFrag(new RentalTabHistory(),"Rental History");
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) toolbar.findViewById(R.id.txtTitle);
        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.WHITE);
        txtTitle.setText(R.string.order_history);
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
