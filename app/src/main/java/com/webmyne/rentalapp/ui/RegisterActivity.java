package com.webmyne.rentalapp.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.helper.UIHelper;

import net.cachapa.expandablelayout.ExpandableLayout;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtPassword, edtConPassword;
    private TfTextView txtLogin;
    private Context context;
    private boolean passwordPress = false;
    private LinearLayout llPersonal, llAddress;
    private ImageView personal_arrow, address_arrow;
    private ExpandableLayout presonal_expandableLayout, address_expandableLayout;
    private RelativeLayout rv_root_main;
    private TfButton btnNext, btnSubmit;
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
        llPersonal = (LinearLayout) findViewById(R.id.linear_personal);
        rv_root_main = (RelativeLayout) findViewById(R.id.rv_root_main);
        llAddress = (LinearLayout) findViewById(R.id.linear_address);
        personal_arrow = (ImageView) findViewById(R.id.personal_arrow);
        address_arrow = (ImageView) findViewById(R.id.address_arrow);
        presonal_expandableLayout = (ExpandableLayout) findViewById(R.id.personal_detail_expandable);
        presonal_expandableLayout.expand();
        address_expandableLayout = (ExpandableLayout) findViewById(R.id.address_detail_expandable);
        address_expandableLayout.collapse();
        btnNext = (TfButton) findViewById(R.id.btnNext);
        btnSubmit = (TfButton) findViewById(R.id.btnSubmit);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtConPassword = (EditText) findViewById(R.id.edtConformPassword);
        txtLogin = (TfTextView) findViewById(R.id.txtLogin);
        clickAction();
        rv_root_main.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = rv_root_main.getRootView().getHeight() - rv_root_main.getHeight();
                if (heightDiff > UIHelper.dpToPx(RegisterActivity.this, 160)) { // if more than 200 dp, it's probably a keyboard...
                    // ... do something here
                    btnSubmit.setVisibility(View.GONE);
                } else {
                    btnSubmit.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void clickAction() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButtonClick();
                /*presonal_expandableLayout.collapse();
                address_expandableLayout.expand();*/

            }
        });
        llPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presonal_expandableLayout.isExpanded()) {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(personal_arrow, "rotation", 0f, 180f);
                    animation.setDuration(400).start();
                    presonal_expandableLayout.collapse();
                } else {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(personal_arrow, "rotation", 180f, 0f);
                    animation.setDuration(400).start();
                    presonal_expandableLayout.expand();
                }
            }
        });

        llAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (address_expandableLayout.isExpanded()) {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(address_arrow, "rotation", 180f, 0f);
                    animation.setDuration(400).start();
                    address_expandableLayout.collapse();
                } else {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(address_arrow, "rotation", 0f, 180f);
                    animation.setDuration(400).start();
                    address_expandableLayout.expand();
                }
            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context,LoginActivity.class);
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
                            edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(RegisterActivity.this, R.drawable.eye_black), null);
                            edtPassword.setSelection(edtPassword.length());
                            passwordPress = false;
                        } else {
                            edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(RegisterActivity.this, R.drawable.eye_red), null);
                            passwordPress = true;
                            edtPassword.setSelection(edtPassword.length());
                        }
                        return true;
                    }
                }
                return false;
            }
        });

        edtConPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (edtConPassword.getRight() - edtConPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                        if (passwordPress) {
                            edtConPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            edtConPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(RegisterActivity.this, R.drawable.eye_black), null);
                            edtConPassword.setSelection(edtConPassword.length());
                            passwordPress = false;
                        } else {
                            edtConPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            edtConPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(RegisterActivity.this, R.drawable.eye_red), null);
                            passwordPress = true;
                            edtConPassword.setSelection(edtConPassword.length());
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void nextButtonClick() {
        if (presonal_expandableLayout.isExpanded()) {
            if (presonal_expandableLayout.isExpanded()) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(personal_arrow, "rotation", 0f, 180f);
                animation.setDuration(400).start();

                presonal_expandableLayout.collapse();
                ObjectAnimator animation1 = ObjectAnimator.ofFloat(address_arrow, "rotation", 0f, 180f);
                animation1.setDuration(400).start();
                address_expandableLayout.expand();
            }
        }
    }
}
