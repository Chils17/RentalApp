package com.webmyne.rentalapp.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.ui.BaseActivity;

/**
 * Created by chintans on 11-07-2017.
 */

public class BaseFragment extends Fragment {
    /**
     * The View.
     */
    protected View view;

    /**
     * The Default string.
     */
    protected String defaultString = "";
    /**
     * The Activity.
     */
    private BaseActivity baseActivity;
    /**
     * Gets base activity.
     *
     * @return the base activity
     */
    public BaseActivity getBaseActivity()
    {
        return baseActivity;
    }

    /**
     * Sets base activity.
     *
     * @param baseActivity the base activity
     */
    public void setBaseActivity(BaseActivity baseActivity)
    {
        this.baseActivity = baseActivity;
    }
    /**
     * On fragment back press boolean.
     *
     * @return the boolean
     */
    public boolean onFragmentBackPress()
    {
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }



}
