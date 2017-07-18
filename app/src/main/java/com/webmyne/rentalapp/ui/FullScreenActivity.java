package com.webmyne.rentalapp.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.FullScreenImageAdapter;
import com.webmyne.rentalapp.adapter.ProductDetailPagerAdapter;

public class FullScreenActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FullScreenImageAdapter adapter;
    private ProductDetailPagerAdapter productDetailPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        viewPager = (ViewPager) findViewById(R.id.pager);

        Intent intent=getIntent();
        int position = intent.getIntExtra("image", 0);

      //  adapter = new FullScreenImageAdapter(FullScreenActivity.this, position);

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);
    }
}
