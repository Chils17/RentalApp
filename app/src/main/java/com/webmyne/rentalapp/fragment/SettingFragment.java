package com.webmyne.rentalapp.fragment;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.ui.AboutUsActivity;
import com.webmyne.rentalapp.ui.BaseActivity;
import com.webmyne.rentalapp.ui.ContactUsActivity;
import com.webmyne.rentalapp.ui.FAQActivity;
import com.webmyne.rentalapp.ui.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends BaseFragment {


    private TfTextView txtAbout;
    private TfTextView txtContact;
    private TfTextView txtFaq;
    private TfTextView txtChangeLang;

    @SuppressLint({"ValidFragment", "Unused"})
    private SettingFragment() {
    }

    @SuppressLint("ValidFragment")
    private SettingFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }


    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new SettingFragment(activity);
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
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        initToolbar();
        init(view);

        return view;
    }

    private void initToolbar() {
        getBaseActivity().setHeader(getResources().getString(R.string.left_drawer_tv_settings));
    }

    private void init(View view) {
        txtAbout = (TfTextView) view.findViewById(R.id.txtAbout);
        txtContact = (TfTextView) view.findViewById(R.id.txtContact);
        txtFaq = (TfTextView) view.findViewById(R.id.txtFaq);
        txtChangeLang = (TfTextView) view.findViewById(R.id.txtChangeLang);

        actionListener();
    }

    private void actionListener() {
        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(getActivity(), AboutUsActivity.class);
            }
        });

        txtContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(getActivity(), ContactUsActivity.class);
            }
        });

        txtFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(getActivity(), FAQActivity.class);
            }
        });

        txtChangeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
