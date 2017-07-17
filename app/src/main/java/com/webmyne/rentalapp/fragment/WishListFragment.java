package com.webmyne.rentalapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.WishlistAdapter;
import com.webmyne.rentalapp.model.WishList;
import com.webmyne.rentalapp.ui.BaseActivity;

import java.util.ArrayList;

public class WishListFragment extends BaseFragment {
    private WishlistAdapter wishlistAdapter;
    private ArrayList<WishList> wishLists;
    private RecyclerView recyclerView;

    private String[] bookName = {"Killing Hemingway","Infinity","Connection Culture","Product Lunch","Data Capture"};
    private String[] bookPrice = {"₹1000","₹500","₹750","₹200","₹100"};
    private String[] bookAuthor = {"Brian D. Meeks","Jenny Smith","Jason Pankau","Tom Weaver","Forte"};
    private Integer[] bookImage = {R.drawable.book1, R.drawable.book4, R.drawable.book1, R.drawable.book4, R.drawable.book1};


    @SuppressLint({"ValidFragment", "Unused"})
    private WishListFragment() {
    }

    @SuppressLint("ValidFragment")
    private WishListFragment(BaseActivity activity) {
        setBaseActivity(activity);
    }


    public static BaseFragment getFragment(BaseActivity activity) {
        BaseFragment fragment = new WishListFragment(activity);
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
        View itemView = inflater.inflate(R.layout.fragment_wishlist, container, false);
        init(itemView);
        initToolbar();
        return itemView;
    }

    private void initToolbar() {
        getBaseActivity().setHeader(getResources().getString(R.string.wish_list));
    }

    private void init(View itemView) {
        recyclerView = (RecyclerView) itemView.findViewById(R.id.wishList_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
        wishLists = new ArrayList<>();
        for (int i = 0; i < bookName.length; i++){
            wishLists.add(new WishList(
                    bookImage[i], bookName[i], bookPrice[i], bookAuthor[i]
            ));
        }
        wishlistAdapter = new WishlistAdapter(getBaseActivity(), wishLists);
        recyclerView.setAdapter(wishlistAdapter);
    }

}
