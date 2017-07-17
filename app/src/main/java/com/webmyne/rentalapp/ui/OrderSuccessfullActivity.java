package com.webmyne.rentalapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;

public class OrderSuccessfullActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TfTextView txtTitle;
    private TfButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_successfull);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) findViewById(R.id.txtTitle);

        // toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        txtTitle.setText("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();

        actionListener();
    }

    private void init() {
        btnHome = (TfButton) findViewById(R.id.btnHome);
    }

    private void actionListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(getApplicationContext(), DashboardActivity.class);
                finish();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(getApplicationContext(), DashboardActivity.class);
                finish();
            }
        });
    }
}
