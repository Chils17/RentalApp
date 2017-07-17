package com.webmyne.rentalapp.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.ui.BaseActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyRewardsFragment extends BaseFragment {


    @SuppressLint({"ValidFragment", "Unused"})
    private MyRewardsFragment() {
    }

    @SuppressLint("ValidFragment")
    private MyRewardsFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }


    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new MyRewardsFragment(activity);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseActivity((BaseActivity) getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);

        initToolbar();

        return view;
    }

    private void initToolbar() {
        getBaseActivity().setHeader(getResources().getString(R.string.my_rewards));
    }

}
