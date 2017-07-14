package com.webmyne.rentalapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.MyCartAdapter;
import com.webmyne.rentalapp.adapter.RentalCartAdapter;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.MyCart;
import com.webmyne.rentalapp.model.RentCart;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RentalCartFragment extends Fragment {


    private TfTextView emptyView;
    private RecyclerView rvRentCart;
    private ArrayList<RentCart> rentCartList;
    private RentalCartAdapter adapter;

    public RentalCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_rental_cart, container, false);

        init(itemView);

        return itemView;
    }

    private void init(View itemView) {
        emptyView = (TfTextView) itemView.findViewById(R.id.emptyView);
        rvRentCart = (RecyclerView) itemView.findViewById(R.id.rvRentCart);

        initRecyclerView();

    }

    private void initRecyclerView() {
        rvRentCart.setLayoutManager(new LinearLayoutManager(getContext()));

        rentCartList = new ArrayList<>();

        rentCartList.add(new RentCart(R.drawable.image1, "Killing", "J. K. Rowling", "Available", "Borrow"));
        rentCartList.add(new RentCart(R.drawable.image1, "Infinite of Cloud", "J. K. Rowling", "Available", "In Queue"));
        rentCartList.add(new RentCart(R.drawable.image1, "Connection Culture", "J. K. Rowling", "Available", "In Queue"));
        rentCartList.add(new RentCart(R.drawable.image1, "RentCart Launch Secrets", "J. K. Rowling", "Available", "Borrow"));
        rentCartList.add(new RentCart(R.drawable.image1, "Forte", "J. K. Rowling", "Available", "In Queue"));
        rentCartList.add(new RentCart(R.drawable.image1, "Killing", "J. K. Rowling", "Available", "In Queue"));
        rentCartList.add(new RentCart(R.drawable.image1, "Connection Culture", "J. K. Rowling", "Available", "Borrow"));
        rentCartList.add(new RentCart(R.drawable.image1, "Product Launch Secret", "J. K. Rowling", "Available", "In Queue"));

        Log.e("tag","RentList" +rentCartList);

        adapter = new RentalCartAdapter(getContext(), rentCartList);
        rvRentCart.setAdapter(adapter);
    }

}
