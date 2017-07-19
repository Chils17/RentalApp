package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.fragment.BaseFragment;
import com.webmyne.rentalapp.fragment.DashBoardFragment;
import com.webmyne.rentalapp.fragment.RentFragment;
import com.webmyne.rentalapp.fragment.ShopFragment;
import com.webmyne.rentalapp.helper.LogUtils;

import java.util.Stack;

/**
 * Created by chintans on 11-07-2017.
 */

public class BaseActivity extends AppCompatActivity {

    private boolean showBackMessage = true;

    /**
     * The double back to exit pressed once. It is used to check that user pressed back button twice
     */
    private boolean doubleBackToExitPressedOnce;

    /**
     * The drawer layout, Left navigation drawer.
     */
    private DrawerLayout drawerLayout;

    /**
     * fragment stack to maintain stacks of fragments on activity.
     */
    private Stack<Fragment> fragmentBackStack;

    /**
     * Sets show back message.
     *
     * @param showBackMessage the show back message
     */
    public void setShowBackMessage(boolean showBackMessage) {
        this.showBackMessage = showBackMessage;
    }

    /**
     * Gets drawer layout.
     *
     * @return the drawer layout
     */
    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    /**
     * Sets drawer layout.
     *
     * @param drawerLayout the drawer layout
     */
    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentBackStack = new Stack<>();
    }

    /**
     * To add fragment to a tab. tag -> Tab identifier fragment -> Fragment to show, in tab identified by tag shouldAnimate ->
     * should animate transaction. false when we switch tabs, or adding first fragment to a tab true when when we are pushing more
     * fragment into navigation stack. shouldAdd -> Should add to fragment navigation stack (mStacks.get(tag)). false when we are
     * switching tabs (except for the first time) true in all other cases.
     *
     * @param fragment      the fragment
     * @param shouldAnimate the should animate
     * @param shouldAdd     the should add
     */
    public synchronized void pushAddFragments(Fragment fragment, boolean shouldAnimate, boolean shouldAdd) {
        LogUtils.showInfo("RENTALAPP" + shouldAdd);
        if (fragment != null) {
            fragmentBackStack.push(fragment);
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.content_frame, fragment, String.valueOf(fragmentBackStack.size()));
            ft.commit();
            manager.executePendingTransactions();
            if (drawerLayout != null && fragmentBackStack.size() > 1) {
                Fragment currentFragment = fragmentBackStack.get(fragmentBackStack.size() - 1);
                if (currentFragment instanceof DashBoardFragment) {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                } else {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                }
            }
        }
    }
    /**
     * Select the second last fragment in current tab's stack.. which will be shown after the fragment transaction given below
     *
     * @param shouldAnimate the should animate
     */
    public synchronized void popFragments(boolean shouldAnimate) {
        Fragment fragment = null;
        if (fragmentBackStack.size() > 1) {
            fragment = fragmentBackStack.elementAt(fragmentBackStack.size() - 2);
        } else if (!fragmentBackStack.isEmpty()) {
            fragment = fragmentBackStack.elementAt(fragmentBackStack.size() - 1);
        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (fragment != null) {
            if (fragment.isAdded()) {
                ft.remove(fragmentBackStack.elementAt(fragmentBackStack.size() - 1));
                if (fragmentBackStack.size() > 1) {
                    ft.show(fragment).commit();
                }
            } else {
                ft.replace(R.id.content_frame, fragment).commit();
            }
            fragmentBackStack.pop();
            manager.executePendingTransactions();
            // Here we checking that whether we have to close navigation drawer on fragments or not.
            if (!fragmentBackStack.isEmpty() && isSlideBarOpen(fragmentBackStack.get(fragmentBackStack.size() - 1)) && drawerLayout != null) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                if (fragmentBackStack.get(fragmentBackStack.size() - 1) instanceof DashBoardFragment) {
                    DashBoardFragment homeFragment = (DashBoardFragment) fragmentBackStack.get(fragmentBackStack.size() - 1);
                }
            }
        }
    }

    /**
     * @param currentFragment current Fragment
     * @return is we have to open navigation drawer.
     */
    private boolean isSlideBarOpen(Fragment currentFragment) {
        return currentFragment instanceof DashBoardFragment;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (!getFragments().empty()) {
            Fragment fragment = getFragments().get(getFragments().size() - 1);
            if (fragment != null) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    /**
     * Gets fragments.
     *
     * @return the fragments
     */
    public Stack<Fragment> getFragments() {
        return fragmentBackStack;
    }

    /**
     * @return is we have to open navigation drawer.
     */
    /*private boolean isSlideBarOpen(Fragment currentFragment)
    {
        return currentFragment instanceof HomeFragment || currentFragment instanceof NotificationCenterFragment;
    }*/
    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawers();
            return;
        }
        if (fragmentBackStack.size() <= 1) {
            if (showBackMessage) {
                doubleTapOnBackPress();
            } else {
                finish();
            }
        } else {
            if (!((BaseFragment) fragmentBackStack.get(fragmentBackStack.size() - 1)).onFragmentBackPress()) {
                Fragment currentFragment = fragmentBackStack.get(fragmentBackStack.size() - 1);
                if (currentFragment instanceof ShopFragment) {
                    loadHomeFragment();
                } else if (currentFragment instanceof RentFragment) {
                    loadHomeFragment();
                } else if (currentFragment instanceof MyAccountFragment) {
                    loadHomeFragment();
                } else if (currentFragment instanceof DashBoardFragment) {
                    doubleTapOnBackPress();
                } else {
                    popFragments(true);
                }
            }
        }
    }

    /**
     * this method load dashboard fragment
     */
    public void loadHomeFragment() {
        getFragments().clear();
        Fragment fragmentToPush = DashBoardFragment.getFragment(this);
        pushAddFragments(fragmentToPush, false, true);
    }


    /**
     * This method is used to set text of header
     *
     * @param headerText the header text
     */
    public void setHeader(String headerText) {
        ((TfTextView) findViewById(R.id.txtTitle)).setText(headerText);
    }

    /**
     * method handle for show notification for close the application & Stop app to Close when there is no any remaining Fragment
     * in Stack and User press Back Press
     */
    void doubleTapOnBackPress() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.click_back_to_exit), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }

    /**
     * Common method to hide keyboard
     *
     * @param editText focused edit text.
     */
    public void hideKeyBoard(EditText editText) {
        if (editText != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }
    /**
     * Common net error.
     *
     * @param cause the cause
     */
    public void commonNetError(String cause, boolean isPop) {
        /*closeProgress();
        new ToastUtils(this).showToast(cause);*/
        if (isPop) {
            this.popFragments(true);
        }
    }
    public void isVisibleCartLayout(boolean isVisible){
        if(isVisible){
            ((RelativeLayout) findViewById(R.id.cartRelativeLayout)).setVisibility(View.VISIBLE);
        }else {
            ((RelativeLayout) findViewById(R.id.cartRelativeLayout)).setVisibility(View.GONE);
        }
    }

}
