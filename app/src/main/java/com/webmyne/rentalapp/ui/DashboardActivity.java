package com.webmyne.rentalapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.fragment.DashBoardFragment;
import com.webmyne.rentalapp.helper.LogUtils;

/**
 * Created by chintans on 11-07-2017.
 */

public class DashboardActivity extends BaseActivity implements View.OnClickListener {
    //region views
    private LinearLayout left_drawer_ll_user_menus;
    private TfTextView tv_footer_shop, tv_footer_rent, tv_footer_account;
    /**
     * current Instance of home activity
     */
    private static DashboardActivity dashboardActivity;
    /**
     *
     */
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;

    /**
     * Gets home activity.
     *
     * @return the home activity
     */
    public static DashboardActivity getHomeActivity() {
        return dashboardActivity;
    }

    /**
     * Sets home activity.
     *
     * @param dashboardActivity the home activity
     */
    public static void setHomeActivity(DashboardActivity dashboardActivity) {
        DashboardActivity.dashboardActivity = dashboardActivity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setHomeActivity(this);
        setDrawerLayout((DrawerLayout) findViewById(R.id.drawer_layout));
        init();
        setDrawer();
        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    private void setDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, getDrawerLayout(), R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                LogUtils.showInfo(view.toString());
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                LogUtils.showInfo(drawerView.toString());
                invalidateOptionsMenu();
            }
        };
        getDrawerLayout().setDrawerListener(mDrawerToggle);
        getDrawerLayout().post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_footer_account = (TfTextView) findViewById(R.id.tv_footer_account);
        tv_footer_shop = (TfTextView) findViewById(R.id.tv_footer_shop);
        tv_footer_rent = (TfTextView) findViewById(R.id.tv_footer_rent);
        findViewById(R.id.left_drawer_tv_home).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_search).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_rent).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_shop).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_wishlist).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_my_cart).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_settings).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_rewards).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_my_account).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_settings).setOnClickListener(this);
        left_drawer_ll_user_menus = (LinearLayout) findViewById(R.id.left_drawer_ll_user_menus);
    }

    private void selectItem(int position) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getFragments().clear();
        if (position == 0) {
            Fragment fragmentToPush = DashBoardFragment.getFragment(this);
            pushAddFragments(fragmentToPush, false, true);
        }
        getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
    }


    @Override
    public void onClick(View v) {
        onOptionClick(v);
    }

    private void onOptionClick(View view) {
        switch (view.getId()) {
            case R.id.left_drawer_tv_home:
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_search:
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_rent:
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_shop:
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.tv_footer_account:
                Toast.makeText(this, getResources().getString(R.string.common_message_under_development), Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_footer_shop:
                Toast.makeText(this, getResources().getString(R.string.common_message_under_development), Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_footer_rent:
                Toast.makeText(this, getResources().getString(R.string.common_message_under_development), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}