package com.webmyne.rentalapp.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.CustomSpinnerAdapter;
import com.webmyne.rentalapp.adapter.ProductListAdapter;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.Product;

import java.util.ArrayList;


public class ProductListActivity extends AppCompatActivity {

    private RecyclerView rvProduct;
    private TfTextView txtTitle;
    private Toolbar toolbar;
    private ArrayList<Product> productArrayList;
    private ProductListAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private LinearLayout lv;
    private TabLayout tabLayout;
    private ImageView imgClose;
    private CrystalRangeSeekbar rangeSeekbar;
    private TfTextView txtMin;
    private TfTextView txtMax;
    private Spinner spinCustom;
    private TfTextView txtFilter;
    private RadioButton rbPopular;
    private RadioButton rbLH;
    private RadioButton rbHL;
    private RadioButton rbNewest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);
        toolbar.setTitleTextColor(Color.WHITE);
        txtTitle.setText(R.string.product_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        setTypeFace();

        actionListener();

        initRecyclerView();

    }




    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        lv = (LinearLayout) findViewById(R.id.lv);

        rvProduct = (RecyclerView) findViewById(R.id.rvProduct);

        View headerView = LayoutInflater.from(ProductListActivity.this).inflate(R.layout.filter_layout, null, false);
        lv.removeAllViews();
        lv.addView(headerView);

        imgClose = (ImageView) headerView.findViewById(R.id.imgClose);
        txtFilter = (TfTextView) headerView.findViewById(R.id.txtFilter);
        txtFilter.setText(R.string.sort_filter);
        // get seekbar from view
        rangeSeekbar = (CrystalRangeSeekbar) headerView.findViewById(R.id.rangeSeekbar);

        // get min and max text view
        txtMin = (TfTextView) headerView.findViewById(R.id.txtMin);
        txtMax = (TfTextView) headerView.findViewById(R.id.txtMax);
        //spinCustom = (Spinner) headerView.findViewById(R.id.spinCustom);

        rbPopular = (RadioButton) headerView.findViewById(R.id.rbPopular);
        rbLH = (RadioButton) headerView.findViewById(R.id.rbLH);
        rbHL = (RadioButton) headerView.findViewById(R.id.rbHL);
        rbNewest = (RadioButton) headerView.findViewById(R.id.rbNewest);
        setRangeSeekbar();
       // initCustomSpinner();
    }

    private void setTypeFace() {
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "fonts/regular.ttf");
        rbPopular.setTypeface(tf);
        rbLH.setTypeface(tf);
        rbHL.setTypeface(tf);
        rbNewest.setTypeface(tf);
    }


    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(Gravity.END);
            }
        });

    }

    private void initRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);

        rvProduct.setLayoutManager(manager);

        productArrayList = new ArrayList<>();

        productArrayList.add(new Product(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 500", "4.2","212"));
        productArrayList.add(new Product(R.drawable.image1, "Infinite of Cloud", "J. K. Rowling", "₹ 2000", "3.7","651"));
        productArrayList.add(new Product(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", "3.9","544"));
        productArrayList.add(new Product(R.drawable.image1, "Product Launch Secrets", "J. K. Rowling", "₹ 2500", "4.1","725"));
        productArrayList.add(new Product(R.drawable.image1, "Forte", "J. K. Rowling", "₹ 500", "4.4","154"));
        productArrayList.add(new Product(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 2050","4.6","123"));
        productArrayList.add(new Product(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", "4.8","153"));
        productArrayList.add(new Product(R.drawable.image1, "Product Launch Secret", "J. K. Rowling", "₹ 2500","4.2","754"));


        adapter = new ProductListAdapter(getApplicationContext(), productArrayList);
        rvProduct.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filter:
                mDrawerLayout.openDrawer(Gravity.END);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setRangeSeekbar() {
        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                txtMin.setText(String.valueOf(minValue));
                txtMax.setText(String.valueOf(maxValue));
            }
        });

        // set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rangeSeekbar.setMinValue(0).setMaxValue(1000).setMinStartValue(10).setMaxStartValue(100).apply();
            }
        }, 5000);*/
    }

    private void initCustomSpinner() {

        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(ProductListActivity.this, numbers);
        spinCustom.setAdapter(customSpinnerAdapter);
        spinCustom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
