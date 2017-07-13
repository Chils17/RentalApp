package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;


public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgUser;
    private Context context;
    private TfTextView txtUsername;
    private TfTextView txtMembership;
    private TfTextView txtWishlist;
    private TfTextView txtPersonalInfo;
    private TfTextView txtReferfriend;
    private TfTextView txtOrderhistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        context = this;
        init();
    }

    private void init() {
        txtOrderhistory = (TfTextView) findViewById(R.id.txtOrderhistory);
        txtReferfriend = (TfTextView) findViewById(R.id.txtReferfriend);
        txtPersonalInfo = (TfTextView) findViewById(R.id.txtPersonalInfo);
        txtWishlist = (TfTextView) findViewById(R.id.txtWishlist);
        txtMembership = (TfTextView) findViewById(R.id.txtMembership);
        txtUsername = (TfTextView) findViewById(R.id.txtUsername);
        imgUser = (ImageView) findViewById(R.id.imgUser);

        txtOrderhistory.setOnClickListener(this);
        txtReferfriend.setOnClickListener(this);
        txtPersonalInfo.setOnClickListener(this);
        txtWishlist.setOnClickListener(this);
        txtMembership.setOnClickListener(this);

        Glide.with(context).load(R.drawable.man).asBitmap().centerCrop().into(new BitmapImageViewTarget(imgUser) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgUser.setImageDrawable(circularBitmapDrawable);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.txtMembership:
                Intent intentMembership = new Intent(context,MembershipActivity.class);
                startActivity(intentMembership);
                break;

            case R.id.txtOrderhistory:
                Intent intentOderhistory = new Intent(context,OrderhistoryActivity.class);
                startActivity(intentOderhistory);
                break;

            case R.id.txtPersonalInfo:
                Intent intentPersonalInfo = new Intent(context,ProfileActivity.class);
                startActivity(intentPersonalInfo);
                break;

            case R.id.txtReferfriend:
                Functions.shareApp(context);
                break;

            case  R.id.txtWishlist:
                Intent intentWishlist = new Intent(context,WishlistActivity.class);
                startActivity(intentWishlist);
                break;
        }
    }
}
