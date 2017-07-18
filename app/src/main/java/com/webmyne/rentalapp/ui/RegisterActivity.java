package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.ProductImage;

public class RegisterActivity extends AppCompatActivity {

    private TfTextView txtLogin;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Functions.fireIntent(context,LoginActivity.class);
    }

    private void init() {
        context = this;
        txtLogin = (TfTextView) findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context,LoginActivity.class);
                finish();
            }
        });
    }
}
