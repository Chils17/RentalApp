package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfTextView;

public class LoginActivity extends AppCompatActivity {

    private TfTextView txtRegister;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        context = this;
        txtRegister = (TfTextView) findViewById(R.id.txtRegister);

        clickListener();
    }

    private void clickListener() {
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
