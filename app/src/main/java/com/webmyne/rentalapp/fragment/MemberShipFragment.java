package com.webmyne.rentalapp.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.ui.BaseActivity;

public class MemberShipFragment extends AppCompatActivity {
    private Toolbar toolbar;
    private TfTextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        init();
    }

    private void init() {

        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) toolbar.findViewById(R.id.txtTitle);
        toolbar.setTitle("");

        txtTitle.setText(R.string.member_ship);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
/*public class MemberShipFragment extends BaseFragment {

    @SuppressLint({"ValidFragment", "Unused"})
    private MemberShipFragment() {
    }

    @SuppressLint("ValidFragment")
    private MemberShipFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }

    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new MemberShipFragment(activity);
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
        View itemView = inflater.inflate(R.layout.activity_membership, container, false);
        init(itemView);
        return itemView;
    }
    private void init(View itemView) {
        initToolbar(itemView);
    }
    private void initToolbar(View itemView) {
        getBaseActivity().setHeader(getResources().getString(R.string.member_ship));
    }
}*/
