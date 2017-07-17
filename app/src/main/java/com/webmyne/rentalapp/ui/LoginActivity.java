package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;

public class LoginActivity extends AppCompatActivity {

    private TfTextView txtRegister;
    private Context context;
    private EditText edtPassword;
    private boolean passwordPress = false;
    private TfButton btnExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        context = this;
        txtRegister = (TfTextView) findViewById(R.id.txtRegister);
        btnExplore = (TfButton) findViewById(R.id.btnExplore);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
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
        btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(LoginActivity.this, DashboardActivity.class);
                finish();
            }
        });

        edtPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (edtPassword.getRight() - edtPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                        if (passwordPress) {
                            edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(LoginActivity.this, R.drawable.eye_black), null);
                            edtPassword.setSelection(edtPassword.length());
                            passwordPress = false;
                        } else {
                            edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(LoginActivity.this, R.drawable.eye_red), null);
                            passwordPress = true;
                            edtPassword.setSelection(edtPassword.length());
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

}
