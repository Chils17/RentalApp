package com.webmyne.rentalapp.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.RentCategoryAdapter;
import com.webmyne.rentalapp.adapter.ShopCategoryAdapter;
import com.webmyne.rentalapp.custom.TfEditText;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.helper.DividerDecoration;
import com.webmyne.rentalapp.model.Rent;
import com.webmyne.rentalapp.model.Shop;
import com.webmyne.rentalapp.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RentFragment extends BaseFragment {


    private TfTextView txtTitle;
    private TfTextView emptyView;
    private RecyclerView rvRent;
    private TfEditText edtSearch;
    private ArrayList<Rent> rentList;
    private RentCategoryAdapter adapter;

    @SuppressLint({"ValidFragment", "Unused"})
    private RentFragment() {
    }

    @SuppressLint("ValidFragment")
    private RentFragment(BaseActivity activity) {
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
        BaseFragment fragment = new RentFragment(activity);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_rent, container, false);
        emptyView = (TfTextView) itemView.findViewById(R.id.emptyView);
        rvRent = (RecyclerView) itemView.findViewById(R.id.rvRent);
        edtSearch = (TfEditText) itemView.findViewById(R.id.edtSearch);
        initToolbar();
        initRecyclerView();
        return itemView;
    }

    private void initToolbar() {
        getBaseActivity().setHeader(getResources().getString(R.string.rent_category));
        getBaseActivity().isVisibleCartLayout(true);
    }


    private void initRecyclerView() {
        rvRent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRent.addItemDecoration(new DividerDecoration(getContext()));
        rentList = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            Rent rent = new Rent();
            rent.setName("Age 1 to 5");
            rentList.add(rent);
        }

        adapter = new RentCategoryAdapter(getContext(), rentList);
        rvRent.setAdapter(adapter);
    }

}
