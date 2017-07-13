package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.webmyne.rentalapp.custom.FontType;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
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

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public View getTabView(int position) {
        TfTextView tfTextView = new TfTextView(context);
        tfTextView.setText(mFragmentTitleList.get(position));
        //Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/ArchivoBlack-Regular.ttf");
        tfTextView.setTypeface(Functions.getFontType(context, FontType.Regular.getId()));
        tfTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tfTextView.setTextColor(ContextCompat.getColor(context, android.R.color.white));
        tfTextView.setGravity(Gravity.CENTER);
        return tfTextView;
    }

    public View getSelectedTabView(int position) {
        TfTextView tfTextView = new TfTextView(context);
        tfTextView.setText(mFragmentTitleList.get(position));
        tfTextView.setTypeface(Functions.getFontType(context, FontType.Bold.getId()));
        //Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/ArchivoBlack-Regular.ttf");
        //tfTextView.setTypeface(typeface);
        tfTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        //tfTextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tfTextView.setTextColor(ContextCompat.getColor(context, android.R.color.white));
        tfTextView.setGravity(Gravity.CENTER);
        return tfTextView;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
