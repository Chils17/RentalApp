package com.webmyne.rentalapp.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.varunest.sparkbutton.SparkButton;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.ProductDetailPagerAdapter;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;

import me.relex.circleindicator.CircleIndicator;

import static com.webmyne.rentalapp.R.id.img_like;

public class ProductActivity extends AppCompatActivity {

    private TfTextView txtTitle;
    private TfTextView txtFullDesc;
    private TfTextView txtDesc;
    private TfTextView textViewer;
    private TfTextView txtPublication;
    private TfTextView txtBookCode;
    private TfTextView txtPage;
    private TfTextView txtPrice;
    private TfTextView txtCategory;
    private TfTextView txtAuthor;
    private TfTextView txtItemName;
    private CircleIndicator indicator;
    private ImageButton rightnav;
    private ImageButton leftnav;
    private SparkButton imgLike;
    private ViewPager viewPager;
    int images[] = {R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1};
    private Toolbar toolbar;
    private FloatingActionButton floatingCart;
    private ProductDetailPagerAdapter productDetailPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);

        // toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        txtTitle.setText(R.string.harry);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        actionListener();
    }

    private void init() {
        txtFullDesc = (TfTextView) findViewById(R.id.txtFullDesc);
        txtDesc = (TfTextView) findViewById(R.id.txtDesc);
        textViewer = (TfTextView) findViewById(R.id.textViewer);
        txtPublication = (TfTextView) findViewById(R.id.txtPublication);
        txtBookCode = (TfTextView) findViewById(R.id.txtBookCode);
        txtPage = (TfTextView) findViewById(R.id.txtPage);
        txtPrice = (TfTextView) findViewById(R.id.txtPrice);
        txtCategory = (TfTextView) findViewById(R.id.txtCategory);
        txtAuthor = (TfTextView) findViewById(R.id.txtAuthor);
        txtItemName = (TfTextView) findViewById(R.id.txtItemName);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        rightnav = (ImageButton) findViewById(R.id.right_nav);
        leftnav = (ImageButton) findViewById(R.id.left_nav);
        imgLike = (SparkButton) findViewById(R.id.img_like);
        floatingCart = (FloatingActionButton) findViewById(R.id.floatingCart);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        productDetailPagerAdapter = new ProductDetailPagerAdapter(ProductActivity.this, images);
        viewPager.setAdapter(productDetailPagerAdapter);
        indicator.setViewPager(viewPager);
    }

    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        leftnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewPager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    viewPager.setCurrentItem(tab);
                } else if (tab == 0) {
                    viewPager.setCurrentItem(tab);
                }
            }
        });

        rightnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewPager.getCurrentItem();
                tab++;
                viewPager.setCurrentItem(tab);
            }
        });

        floatingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(getApplicationContext(),CartActivity.class);
            }
        });

    }
}
