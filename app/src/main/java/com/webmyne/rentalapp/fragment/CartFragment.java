package com.webmyne.rentalapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.TabMenuAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.ui.BaseActivity;

public class CartFragment extends BaseFragment {
    private Toolbar toolbar;
    private TfTextView txtTitle;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private TabMenuAdapter tabMenuAdapter;

    @SuppressLint({"ValidFragment", "Unused"})
    private CartFragment() {
    }

    @SuppressLint("ValidFragment")
    private CartFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }

    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new CartFragment(activity);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseActivity((BaseActivity) getActivity());
    }

    private void init(View itemView) {
        mViewPager = (ViewPager) itemView.findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) itemView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        highLightCurrentTab(0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_main_cart, container, false);
        init(itemView);
        actionListener(itemView);
        initToolbar();
        return itemView;
    }

    private void initToolbar() {
        getBaseActivity().setHeader(getResources().getString(R.string.cart));
    }


    private void actionListener(View itemView) {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        tabMenuAdapter = new TabMenuAdapter(getFragmentManager(), getBaseActivity());
        tabMenuAdapter.addFragment(new MyCartFragment(), getString(R.string.my_cart));
        tabMenuAdapter.addFragment(new RentalCartFragment(), getString(R.string.rental_cart));
        viewPager.setAdapter(tabMenuAdapter);
    }

    private void highLightCurrentTab(int position) {

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(null);
            tab.setCustomView(tabMenuAdapter.getTabView(i));
        }

        TabLayout.Tab tab = tabLayout.getTabAt(position);
        tab.setCustomView(null);
        tab.setCustomView(tabMenuAdapter.getSelectedTabView(position));

    }
}
