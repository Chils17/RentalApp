package com.webmyne.rentalapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.MyCartAdapter;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.MyCart;
import com.webmyne.rentalapp.ui.CheckoutOrderActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment {


    private TfTextView emptyView;
    public RecyclerView rvMyCart;
    private ArrayList<MyCart> myCartList;
    private MyCartAdapter adapter;
    private TfButton checkOut;

    public MyCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView=inflater.inflate(R.layout.fragment_my_cart, container, false);

        init(itemView);

        return itemView;
    }

    private void init(View itemView) {
        emptyView = (TfTextView) itemView.findViewById(R.id.emptyView);
        rvMyCart = (RecyclerView) itemView.findViewById(R.id.rvMyCart);
        checkOut = (TfButton) itemView.findViewById(R.id.checkOut);

        initRecyclerView();

        actionListener();

    }

    private void actionListener() {
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Functions.fireIntent(getActivity(), ShippingBillingAddrssActivity.class);*/
                Functions.fireIntent(getActivity(), CheckoutOrderActivity.class);
            }
        });
    }

    private void initRecyclerView() {
        rvMyCart.setLayoutManager(new LinearLayoutManager(getContext()));

        myCartList = new ArrayList<>();

        myCartList.add(new MyCart(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 500", 2));
        myCartList.add(new MyCart(R.drawable.image1, "Infinite of Cloud", "J. K. Rowling", "₹ 2000", 3));
        myCartList.add(new MyCart(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", 4));
        myCartList.add(new MyCart(R.drawable.image1, "MyCart Launch Secrets", "J. K. Rowling", "₹ 2500", 5));
        myCartList.add(new MyCart(R.drawable.image1, "Forte", "J. K. Rowling", "₹ 500", 5));
        myCartList.add(new MyCart(R.drawable.image1, "Killing", "J. K. Rowling", "₹ 2050", 4));
        myCartList.add(new MyCart(R.drawable.image1, "Connection Culture", "J. K. Rowling", "₹ 500", 3));
        myCartList.add(new MyCart(R.drawable.image1, "Product Launch Secret", "J. K. Rowling", "₹ 2500", 2));


        adapter = new MyCartAdapter(getContext(), myCartList);
        rvMyCart.setAdapter(adapter);
    }

}
