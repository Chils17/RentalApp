package com.webmyne.rentalapp.ui;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.FullScreenImageAdapter;
import com.webmyne.rentalapp.adapter.ProductDetailPagerAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.ProductImage;

import java.util.ArrayList;

public class FullScreenActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TfTextView txtTitle;
    private ViewPager viewPager;
    private FullScreenImageAdapter adapter;
    private ArrayList<ProductImage> imageList = new ArrayList<>();
    private String position = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);
        // toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle("");
        toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.transparent));
        setSupportActionBar(toolbar);

        txtTitle.setText("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        actionListener();

        initViewPager();
    }


    private void init() {
        viewPager = (ViewPager) findViewById(R.id.pager);

    }

    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initViewPager() {
        if (getIntent() != null) {
            imageList = (ArrayList<ProductImage>) getIntent().getExtras().get("imageListArray");
            position = getIntent().getExtras().getString("imageListPosition");
        }
        adapter = new FullScreenImageAdapter(FullScreenActivity.this, imageList);
        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(Integer.parseInt(position));
    }
}
