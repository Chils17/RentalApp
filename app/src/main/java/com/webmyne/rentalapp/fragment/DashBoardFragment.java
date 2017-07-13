package com.webmyne.rentalapp.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.FeaturedBooksRecyclerAdapter;
import com.webmyne.rentalapp.adapter.NewArrivalRecyclerAdapter;
import com.webmyne.rentalapp.adapter.PopularRecyclerAdapter;
import com.webmyne.rentalapp.adapter.ProductPagerAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.ui.BaseActivity;
import com.webmyne.rentalapp.ui.DashboardActivity;
import com.webmyne.rentalapp.ui.customviews.LayoutView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by chintans on 11-07-2017.
 */

public class DashBoardFragment extends BaseFragment {

    //region variables
    private static ViewPager mProductPager;
    private static int currentPage = 0;
    private CircleIndicator indicator;
    private static final Integer[] mBookArray = {R.drawable.book, R.drawable.book_4, R.drawable.album3, R.drawable.album4, R.drawable.album5};
    private ArrayList<Integer> mBookArrayList = new ArrayList<Integer>();
    private Handler handler = null;
    private Timer swipeTimer;
    //region views
    private LinearLayout ll_popular_books_viewall,ll_new_arrivals_viewall,ll_new_arrivals_content, ll_new_arrivals_content_top, ll_new_arrivals_content_bottom, ll_popular_content_bottom, ll_populars_content_top, ll_featured_content_top, ll_featured_content_bottom;
    private LayoutView layoutView;


    @SuppressLint({"ValidFragment", "Unused"})
    private DashBoardFragment() {
    }

    @SuppressLint("ValidFragment")
    private DashBoardFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }

    /**
     * This method is used to create Fragment instance . It is used to restrict developer to provide
     * following parameters which are mandatory for this appMapFragment
     *
     * @param activity instance of activity
     * @return instance of this {@link DashBoardFragment}
     */
    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new DashBoardFragment(activity);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseActivity((BaseActivity) getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        init(view);
        return view;
    }


    private void init(View view) {
        ll_new_arrivals_content = (LinearLayout) view.findViewById(R.id.ll_new_arrivals_content);
        ll_popular_books_viewall = (LinearLayout) view.findViewById(R.id.ll_popular_books_viewall);
        ll_new_arrivals_viewall = (LinearLayout) view.findViewById(R.id.ll_new_arrivals_viewall);
        ll_new_arrivals_content_top = (LinearLayout) view.findViewById(R.id.ll_new_arrivals_content_top);
        ll_new_arrivals_content_bottom = (LinearLayout) view.findViewById(R.id.ll_new_arrivals_content_bottom);
        ll_populars_content_top = (LinearLayout) view.findViewById(R.id.ll_populars_content_top);
        ll_featured_content_top = (LinearLayout) view.findViewById(R.id.ll_featured_content_top);
        ll_featured_content_bottom = (LinearLayout) view.findViewById(R.id.ll_featured_content_bottom);
        ll_popular_content_bottom = (LinearLayout) view.findViewById(R.id.ll_populars_content_bottom);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        mProductPager = (ViewPager) view.findViewById(R.id.product_pager);
        ll_new_arrivals_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentToPush = ShopFragment.getFragment(getBaseActivity());
                getBaseActivity().pushAddFragments(fragmentToPush, true, true);
            }
        });

        ll_popular_books_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentToPush = RentFragment.getFragment(getBaseActivity());
                getBaseActivity().pushAddFragments(fragmentToPush, true, true);
            }
        });/*tv_footer_account.setOnClickListener(this);
        tv_footer_rent.setOnClickListener(this);
        tv_footer_shop.setOnClickListener(this);*/
        for (int i = 0; i < mBookArray.length; i++) {
            mBookArrayList.add(mBookArray[i]);
        }
        if (mBookArrayList.size() > 0) {
            mProductPager.setAdapter(new ProductPagerAdapter(getBaseActivity(), mBookArrayList));
            indicator.setViewPager(mProductPager);
        }
        // Auto start of viewpager
        handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == mBookArray.length) {
                    currentPage = 0;
                }
                mProductPager.setCurrentItem(currentPage++, true);
            }
        };
        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
        for (int i = 0; i < 2; i++) {
            View hiddenInfo = getBaseActivity().getLayoutInflater().inflate(R.layout.item_product_dashboard_adapter, ll_new_arrivals_content_top, false);
            ll_new_arrivals_content_top.addView(hiddenInfo);

        }
        for (int i = 0; i < 2; i++) {
            View hiddenInfo = getBaseActivity().getLayoutInflater().inflate(R.layout.item_product_dashboard_adapter, ll_new_arrivals_content_top, false);
            ll_new_arrivals_content_bottom.addView(hiddenInfo);

        }
        for (int i = 0; i < 2; i++) {
            View hiddenInfo = getBaseActivity().getLayoutInflater().inflate(R.layout.item_product_dashboard_adapter, ll_new_arrivals_content_top, false);
            ll_populars_content_top.addView(hiddenInfo);
        }
        for (int i = 0; i < 2; i++) {
            View hiddenInfo = getBaseActivity().getLayoutInflater().inflate(R.layout.item_product_dashboard_adapter, ll_new_arrivals_content_top, false);
            ll_popular_content_bottom.addView(hiddenInfo);

        }
        for (int i = 0; i < 2; i++) {
            View hiddenInfo = getBaseActivity().getLayoutInflater().inflate(R.layout.item_product_dashboard_adapter, ll_new_arrivals_content_top, false);
            ll_featured_content_top.addView(hiddenInfo);

        }
        for (int i = 0; i < 2; i++) {
            View hiddenInfo = getBaseActivity().getLayoutInflater().inflate(R.layout.item_product_dashboard_adapter, ll_new_arrivals_content_top, false);
            ll_featured_content_bottom.addView(hiddenInfo);

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBaseActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }


}
