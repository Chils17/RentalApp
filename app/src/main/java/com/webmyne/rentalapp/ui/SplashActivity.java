package com.webmyne.rentalapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.helper.UIHelper;
import com.webmyne.rentalapp.model.ProductImage;

import static android.R.attr.duration;

/**
 * Created by gulamhusen on 14-07-2017.
 */

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    private LinearLayout splashLayout;
    private RelativeLayout loginLayout;

    private TfButton btnExplore, btnSubmit;
    private TfTextView txtRegister;
    private EditText edtPassword;
    private boolean passwordPress = false;
    private Context context;

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
        context = this;
        txtRegister = (TfTextView) findViewById(R.id.txtRegister);
        btnExplore = (TfButton) findViewById(R.id.btnExplore);
        btnSubmit = (TfButton) findViewById(R.id.btnSubmit);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(SplashActivity.this, DashboardActivity.class);
                finish();
            }
        });
        animation();

        clickListener();

    }

    private void animation() {
        final Animation sideOut = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.slide_out_up);
        final Animation sidein = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.slide_in_up);

        splashLayout = (LinearLayout) findViewById(R.id.splashLLayout);
        loginLayout = (RelativeLayout) findViewById(R.id.loginRLayout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sideOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        splashLayout.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                splashLayout.setAnimation(sideOut);
                loginLayout.setVisibility(View.VISIBLE);
                loginLayout.startAnimation(sidein);


               /* int[] coords = {0,0};
                splashLayout.getLocationOnScreen(coords);
                int y = coords[1]-100;

                TranslateAnimation toTop = new TranslateAnimation(0, 0, 0, -y);
                toTop.setDuration(500);
                toTop.setFillAfter(true);
                splashLayout.startAnimation(toTop);
*/


                // ---------------------------------------------------------------------

            /*    int[] coordsLogin = {0,0};
                loginLayout.getLocationOnScreen(coordsLogin);
                int y1 = coordsLogin[1];

                TranslateAnimation toTopLogin = new TranslateAnimation(0, 0 ,-y1,0 );
                toTopLogin.setDuration(800);
                toTopLogin.setFillAfter(false);
                loginLayout.startAnimation(toTopLogin);
                loginLayout.setVisibility(View.VISIBLE);*/
                //  Functions.fireIntentWithClearFlagWithWithPendingTransition(SplashActivity.this, LoginActivity.class);
            }
        }, SPLASH_TIME_OUT);
        if (getIntent() != null && getIntent().hasExtra("CRASHED")) {
            UIHelper.showMessage(SplashActivity.this, getResources().getString(R.string.err_something_went_wrong));
            Throwable throwable = (Throwable) getIntent().getSerializableExtra("EXCEPTION");
        }
    }

    private void clickListener() {

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(SplashActivity.this, IntroActivity.class);
                finish();
            }
        });
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegisterActivity.class);
                startActivity(intent);
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
                            edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(SplashActivity.this, R.drawable.eye_black), null);
                            edtPassword.setSelection(edtPassword.length());
                            passwordPress = false;
                        } else {
                            edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(SplashActivity.this, R.drawable.eye_red), null);
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
