package com.webmyne.rentalapp.fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
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
import com.webmyne.rentalapp.adapter.ShopCategoryAdapter;
import com.webmyne.rentalapp.custom.TfEditText;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.helper.DividerDecoration;
import com.webmyne.rentalapp.model.Shop;
import com.webmyne.rentalapp.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment {


    private TfTextView txtTitle;
    private TfTextView emptyView;
    private TfEditText edtSearch;
    private List<Shop> shopList;
    private ShopCategoryAdapter adapter;
    private RecyclerView rvShop;


    @SuppressLint({"ValidFragment", "Unused"})
    private ShopFragment() {
    }

    @SuppressLint("ValidFragment")
    private ShopFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }


    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new ShopFragment(activity);
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
        View itemView = inflater.inflate(R.layout.fragment_shop, container, false);

        Toolbar toolbar = (Toolbar) itemView.findViewById(R.id.toolbar);
        txtTitle = (TfTextView) itemView.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.shop_category);

        emptyView = (TfTextView) itemView.findViewById(R.id.emptyView);
        rvShop = (RecyclerView) itemView.findViewById(R.id.rvShop);
        edtSearch = (TfEditText) itemView.findViewById(R.id.edtSearch);

        initRecyclerView();

        actionListener();

        return itemView;
    }

    private void actionListener() {

    }

    private void initRecyclerView() {
        rvShop.setLayoutManager(new LinearLayoutManager(getContext()));
        rvShop.addItemDecoration(new DividerDecoration(getContext()));
        shopList = new ArrayList<>();

        shopList.add(new Shop("Art and Craft"));
        shopList.add(new Shop("Coloring and Painting"));

        adapter = new ShopCategoryAdapter(getContext(), shopList);
        rvShop.setAdapter(adapter);
    }

}
