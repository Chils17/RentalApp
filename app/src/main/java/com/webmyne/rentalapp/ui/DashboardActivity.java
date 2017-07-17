package com.webmyne.rentalapp.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.fragment.CartFragment;
import com.webmyne.rentalapp.fragment.DashBoardFragment;
import com.webmyne.rentalapp.fragment.MemberShipFragment;
import com.webmyne.rentalapp.fragment.MemberShipPlansFragment;
import com.webmyne.rentalapp.fragment.RentFragment;
import com.webmyne.rentalapp.fragment.ShopFragment;
import com.webmyne.rentalapp.fragment.WishListFragment;
import com.webmyne.rentalapp.helper.LogUtils;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chintans on 11-07-2017.
 */

public class DashboardActivity extends BaseActivity implements View.OnClickListener {
    //region views
    private LinearLayout left_drawer_ll_user_menus;
    private CircleImageView profilePic;
    /**
     * current Instance of home activity
     */
    private static DashboardActivity dashboardActivity;
    /**
     *
     */
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    /*private Toolbar toolbar;*/

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
        setDrawer();
        initToolbar();
        init();
        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_menu_toolbar));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDrawerLayout().openDrawer(findViewById(R.id.drawer));
            }
        });
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
        mDrawerToggle.syncState();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void init() {
        //left drawer
        profilePic = (CircleImageView) findViewById(R.id.profilePic);
        findViewById(R.id.left_drawer_tv_home).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_search).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_rent).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_shop).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_wishlist).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_my_cart).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_settings).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_rewards).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_my_account).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_membership).setOnClickListener(this);
        findViewById(R.id.left_drawer_tv_settings).setOnClickListener(this);
        findViewById(R.id.ll_footer_account).setOnClickListener(this);
        findViewById(R.id.ll_footer_home).setOnClickListener(this);
        findViewById(R.id.ll_footer_rent).setOnClickListener(this);
        findViewById(R.id.ll_footer_shop).setOnClickListener(this);
        findViewById(R.id.ll_left_drawer_user_detail).setOnClickListener(this);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_drawer_tv_home:
                selectItem(0);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_membership:
               // Fragment fragmentToPushMemberShip = MemberShipFragment.getFragment(this);
                Fragment fragmentToPushMemberShip = MemberShipPlansFragment.getFragment(this);
                pushAddFragments(fragmentToPushMemberShip, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_search:
                Toast.makeText(this, getResources().getString(R.string.common_message_under_development), Toast.LENGTH_SHORT).show();
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_rewards:
                Toast.makeText(this, getResources().getString(R.string.common_message_under_development), Toast.LENGTH_SHORT).show();
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_rent:
                Fragment fragmentToPushRent = RentFragment.getFragment(this);
                pushAddFragments(fragmentToPushRent, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_shop:
                Fragment fragmentToPushShop = ShopFragment.getFragment(this);
                pushAddFragments(fragmentToPushShop, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_my_cart:
                Fragment fragmentToPushCart = CartFragment.getFragment(this);
                pushAddFragments(fragmentToPushCart, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_wishlist:
                Fragment fragmentToPushWishList = WishListFragment.getFragment(this);
                pushAddFragments(fragmentToPushWishList, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.left_drawer_tv_my_account:
                Fragment fragmentToPushAccount = MyAccountFragment.getFragment(this);
                pushAddFragments(fragmentToPushAccount, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.ll_footer_account:
                Fragment fragmentToPushAccountFooter = MyAccountFragment.getFragment(this);
                pushAddFragments(fragmentToPushAccountFooter, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.ll_footer_shop:
                Fragment fragmentToPushShopFooter = ShopFragment.getFragment(this);
                pushAddFragments(fragmentToPushShopFooter, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.ll_footer_rent:
                Fragment fragmentToPushRentFooter = RentFragment.getFragment(this);
                pushAddFragments(fragmentToPushRentFooter, true, true);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            case R.id.ll_footer_home:
                loadHomeFragment();
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
            case R.id.ll_left_drawer_user_detail:
                Functions.fireIntent(this, ProfileActivity.class);
                getDrawerLayout().closeDrawer(findViewById(R.id.drawer));
                break;
            default:
                break;
        }
    }
}
