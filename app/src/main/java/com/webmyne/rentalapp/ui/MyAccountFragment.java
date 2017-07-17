package com.webmyne.rentalapp.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.fragment.BaseFragment;
import com.webmyne.rentalapp.fragment.MemberShipFragment;
import com.webmyne.rentalapp.fragment.WishListFragment;


public class MyAccountFragment extends BaseFragment implements View.OnClickListener {

    private ImageView imgUser;
    private Context context;
    private TfTextView txtUsername;
    private TfTextView txtMembership;
    private TfTextView txtWishlist;
    private TfTextView txtPersonalInfo;
    private TfTextView txtReferfriend;
    private TfTextView txtOrderhistory;


    @SuppressLint({"ValidFragment", "Unused"})
    private MyAccountFragment() {
    }

    @SuppressLint("ValidFragment")
    private MyAccountFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }


    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new MyAccountFragment(activity);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseActivity((BaseActivity) getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.activity_my_account, container, false);
        init(itemView);
        initToolbar();
        return itemView;
    }

    private void initToolbar() {
        getBaseActivity().setHeader(getResources().getString(R.string.left_drawer_tv_my_account));
    }

    private void init(View itemView) {
        txtOrderhistory = (TfTextView) itemView.findViewById(R.id.txtOrderhistory);
        txtReferfriend = (TfTextView) itemView.findViewById(R.id.txtReferfriend);
        txtPersonalInfo = (TfTextView) itemView.findViewById(R.id.txtPersonalInfo);
        txtWishlist = (TfTextView) itemView.findViewById(R.id.txtWishlist);
        txtMembership = (TfTextView) itemView.findViewById(R.id.txtMembership);
        txtUsername = (TfTextView) itemView.findViewById(R.id.txtUsername);
        imgUser = (ImageView) itemView.findViewById(R.id.imgUser);

        txtOrderhistory.setOnClickListener(this);
        txtReferfriend.setOnClickListener(this);
        txtPersonalInfo.setOnClickListener(this);
        txtWishlist.setOnClickListener(this);
        txtMembership.setOnClickListener(this);

        imgUser.setOnClickListener(this);

        Glide.with(getBaseActivity()).load(R.drawable.man).asBitmap().centerCrop().into(new BitmapImageViewTarget(imgUser) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getBaseActivity().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgUser.setImageDrawable(circularBitmapDrawable);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.txtMembership:
                Fragment fragmentToPushMemberShip = MemberShipFragment.getFragment(getBaseActivity());
                getBaseActivity().pushAddFragments(fragmentToPushMemberShip, true, true);
                break;

            case R.id.txtOrderhistory:
                Intent intentOderhistory = new Intent(getBaseActivity(), OrderhistoryActivity.class);
                startActivity(intentOderhistory);
                break;

            case R.id.txtPersonalInfo:
                Intent intentPersonalInfo = new Intent(getBaseActivity(), ProfileActivity.class);
                startActivity(intentPersonalInfo);
                break;

            case R.id.txtReferfriend:
                Functions.shareApp(getBaseActivity());
                break;

            case R.id.txtWishlist:
                Fragment fragmentToPushWishList = WishListFragment.getFragment(getBaseActivity());
                getBaseActivity().pushAddFragments(fragmentToPushWishList, true, true);
                break;

            case  R.id.imgUser:
                Intent intentSplash = new Intent(getBaseActivity(),SplashActivity.class);
                startActivity(intentSplash);
                break;
        }
    }
}
