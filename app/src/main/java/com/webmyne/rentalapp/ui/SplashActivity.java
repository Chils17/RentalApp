package com.webmyne.rentalapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;


import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;

/**
 * Created by gulamhusen on 14-07-2017.
 */

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();*/
                Functions.fireIntentWithClearFlagWithWithPendingTransition(SplashActivity.this, LoginActivity.class);
            }
        }, SPLASH_TIME_OUT);


    }
}
