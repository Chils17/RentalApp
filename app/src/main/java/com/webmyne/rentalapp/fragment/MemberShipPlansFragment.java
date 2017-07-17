package com.webmyne.rentalapp.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.ui.BaseActivity;

public class MemberShipPlansFragment extends BaseFragment {

    @SuppressLint({"ValidFragment", "Unused"})
    private MemberShipPlansFragment() {
    }

    @SuppressLint("ValidFragment")
    private MemberShipPlansFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }

    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new MemberShipPlansFragment(activity);
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
        View itemView = inflater.inflate(R.layout.activity_membership_plans, container, false);
        init(itemView);
        return itemView;
    }
    private void init(View itemView) {
        initToolbar(itemView);
    }
    private void initToolbar(View itemView) {
        getBaseActivity().setHeader(getResources().getString(R.string.member_ship_plan));
    }
}
