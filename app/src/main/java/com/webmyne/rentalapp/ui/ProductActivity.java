package com.webmyne.rentalapp.ui;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.varunest.sparkbutton.SparkButton;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.ProductDetailPagerAdapter;
import com.webmyne.rentalapp.adapter.ProductImageAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.ProductImage;
import com.webmyne.rentalapp.ui.animutils.CircleAnimationUtil;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

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
    private TfTextView txt_cart_counter;
    private RelativeLayout cartRelativeLayout;
    private TfTextView txtAuthor;
    private TfTextView txtItemName;
    private CircleIndicator indicator;
    private ImageButton rightnav;
    private ImageButton leftnav;
    private SparkButton imgLike;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private FloatingActionButton floatingCart;
    private ProductDetailPagerAdapter productDetailPagerAdapter;
    private RecyclerView rvProductImages;
    private ArrayList<ProductImage> productImageList;
    private ProductImageAdapter adapter;
    private int itemCounter = 0;
    private Drawable drawable;
    private ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        imageview = (ImageView) findViewById(R.id.itemCopyIV);
        initToolbar();
        init();
        initRecyclerView();
        initViewPager();
        actionListener();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);
        txt_cart_counter = (TfTextView) findViewById(R.id.txt_cart_counter);
        cartRelativeLayout = (RelativeLayout) findViewById(R.id.cartRelativeLayout);
        cartRelativeLayout.setVisibility(View.VISIBLE);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        txtTitle.setText(R.string.harry);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void init() {
        rvProductImages = (RecyclerView) findViewById(R.id.rvProductImages);
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
        //indicator = (CircleIndicator) findViewById(R.id.indicator);
        // rightnav = (ImageButton) findViewById(R.id.right_nav);
        // leftnav = (ImageButton) findViewById(R.id.left_nav);
        //imgLike = (SparkButton) findViewById(R.id.img_like);
        floatingCart = (FloatingActionButton) findViewById(R.id.floatingCart);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        floatingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeFlyAnimation(imageview);
            }
        });

       /* leftnav.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }

    private void makeFlyAnimation(ImageView targetView) {
        RelativeLayout destView = (RelativeLayout) findViewById(R.id.cartRelativeLayout);

        new CircleAnimationUtil().attachActivity(this).setTargetView(targetView).setMoveDuration(1000).setDestView(destView).setAnimationListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                addItemToCart();
                Toast.makeText(ProductActivity.this, "Continue Shopping...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).startAnimation();

    }

    private void addItemToCart() {
        txt_cart_counter.setText(String.valueOf(++itemCounter));
    }

    private void initRecyclerView() {
        rvProductImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        productImageList = new ArrayList<>();

       /* for (int i = 1; i <= 4; i++) {
            ProductImage productImage = new ProductImage();
            productImage.setImg(R.drawable.image1);

            productImageList.add(productImage);
        }*/

        /*productImageList.add(new ProductImage(R.drawable.album1));
        productImageList.add(new ProductImage(R.drawable.album2));
        productImageList.add(new ProductImage(R.drawable.album3));
        productImageList.add(new ProductImage(R.drawable.album4));*/

        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_5/slider1.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_3/slider3.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_2/slider4.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_4/slider2.jpg"));

        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_5/slider1.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_3/slider3.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_2/slider4.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_4/slider2.jpg"));


        adapter = new ProductImageAdapter(getApplicationContext(), productImageList, new ProductImageAdapter.OnClickItem() {
            @Override
            public void onClickItem(int position) {
                viewPager.setCurrentItem(position);
            }
        });

        rvProductImages.setAdapter(adapter);
        /*Glide.with(this).load(productImageList.get(0).getImg_url()).fitCenter().into(imageview);*/
    }

    private void initViewPager() {
        productImageList = new ArrayList<>();

        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_5/slider1.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_3/slider3.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_2/slider4.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_4/slider2.jpg"));

        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_5/slider1.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_3/slider3.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_2/slider4.jpg"));
        productImageList.add(new ProductImage("http://demo.webmynehost.com/core/libonsite/images/slider/slider_4/slider2.jpg"));
        Glide.with(this).load(productImageList.get(2).getImg_url()).into(imageview);
        productDetailPagerAdapter = new ProductDetailPagerAdapter(ProductActivity.this, productImageList);
        viewPager.setAdapter(productDetailPagerAdapter);
        // indicator.setViewPager(viewPager);
    }


}
