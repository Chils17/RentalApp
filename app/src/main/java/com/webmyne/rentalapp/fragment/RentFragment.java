package com.webmyne.rentalapp.fragment;


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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RentFragment extends Fragment {


    private TfTextView txtTitle;
    private TfTextView emptyView;
    private RecyclerView rvRent;
    private TfEditText edtSearch;
    private ArrayList<Rent> rentList;
    private RentCategoryAdapter adapter;

    public RentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_rent, container, false);
        Toolbar toolbar = (Toolbar) itemView.findViewById(R.id.toolbar);
        txtTitle = (TfTextView) itemView.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.rent_category);

        emptyView = (TfTextView) itemView.findViewById(R.id.emptyView);
        rvRent = (RecyclerView) itemView.findViewById(R.id.rvRent);
        edtSearch = (TfEditText) itemView.findViewById(R.id.edtSearch);

        initRecyclerView();

        return itemView;
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
