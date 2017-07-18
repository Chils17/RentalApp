package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.FontType;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.fragment.CartFragment;
import com.webmyne.rentalapp.ui.ShippingBillingAddrssActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragpatel on 13-07-2017.
 */

public class TabMenuAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private Context context;

    public TabMenuAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }




    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public View getTabView(int position) {
        TfTextView tfTextView = new TfTextView(context);
        tfTextView.setText(mFragmentTitleList.get(position));
        tfTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tfTextView.setTypeface(Functions.getFontType(context, FontType.SemiBold.getId()));
        tfTextView.setTextColor(ContextCompat.getColor(context, R.color.white));
        tfTextView.setGravity(Gravity.CENTER);
        return tfTextView;
    }

    public View getSelectedTabView(int position) {
        TfTextView tfTextView = new TfTextView(context);
        tfTextView.setText(mFragmentTitleList.get(position));
        tfTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        tfTextView.setTypeface(Functions.getFontType(context, FontType.Bold.getId()));
        tfTextView.setTextColor(ContextCompat.getColor(context, R.color.white));
        tfTextView.setGravity(Gravity.CENTER);
        return tfTextView;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
