package com.webmyne.rentalapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.fragment.RentFragment;
import com.webmyne.rentalapp.fragment.ShopFragment;

public class DummyActivity extends AppCompatActivity {

    private Button btnRent;
    private Button btnShop;
    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        init();

        actionListener();

    }

    private void init() {
        container = (FrameLayout) findViewById(R.id.container);
        btnRent = (Button) findViewById(R.id.btnRent);
        btnShop = (Button) findViewById(R.id.btnShop);
    }

    private void actionListener() {
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ShopFragment shopFragment = new ShopFragment(activity);
                setFragment(shopFragment);*/
            }
        });

        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*RentFragment rentFragment = new RentFragment();
                setFragment(rentFragment);*/
            }
        });
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
