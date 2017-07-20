package com.webmyne.rentalapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.ProductGridAdapter;
import com.webmyne.rentalapp.adapter.ProductListAdapter;
import com.webmyne.rentalapp.custom.TfEditText;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.Product;
import com.webmyne.rentalapp.ui.BaseActivity;

import java.util.ArrayList;

/**
 * Created by chintans on 19-07-2017.
 */

public class SearchProductFragment extends BaseFragment {
    //region views
    private TfTextView emptyView;
    private TfEditText edtSearch;
    private RecyclerView rvProduct;

    private ProductGridAdapter adapter;
    private ArrayList<Product> productArrayList = new ArrayList<>();

    @SuppressLint({"ValidFragment", "Unused"})
    private SearchProductFragment() {
    }

    @SuppressLint("ValidFragment")
    private SearchProductFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }

    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new SearchProductFragment(activity);
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
        emptyView = (TfTextView) itemView.findViewById(R.id.emptyView);
        rvProduct = (RecyclerView) itemView.findViewById(R.id.rvShop);
        edtSearch = (TfEditText) itemView.findViewById(R.id.edtSearch);
        initToolbar();
        initRecyclerView();
        return itemView;
    }

    private void initRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(getBaseActivity(), 2);
        rvProduct.setLayoutManager(manager);
        productArrayList = new ArrayList<>();
        productArrayList.add(new Product(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 500", "4.2", "212"));
        productArrayList.add(new Product(R.drawable.image1, "Infinite of Cloud", "J. K. Rowling", "₹ 2000", "3.7", "651"));
        productArrayList.add(new Product(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", "3.9", "544"));
        productArrayList.add(new Product(R.drawable.image1, "Product Launch Secrets", "J. K. Rowling", "₹ 2500", "4.1", "725"));
        productArrayList.add(new Product(R.drawable.image1, "Forte", "J. K. Rowling", "₹ 500", "4.4", "154"));
        productArrayList.add(new Product(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 2050", "4.6", "123"));
        productArrayList.add(new Product(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", "4.8", "153"));
        productArrayList.add(new Product(R.drawable.image1, "Product Launch Secret", "J. K. Rowling", "₹ 2500", "4.2", "754"));
        adapter = new ProductGridAdapter(getBaseActivity(), productArrayList);
        rvProduct.setAdapter(adapter);
    }

    private void initToolbar() {
        getBaseActivity().setHeader(getResources().getString(R.string.search_by_product));
        getBaseActivity().isVisibleCartLayout(true);
    }


}
