package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.RentalHistoryAdapter;
import com.webmyne.rentalapp.model.RentalHistoryList;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class RentalTabHistory extends Fragment{

    private RecyclerView recyclerView;
    private Context context;
    private RentalHistoryAdapter rentalHistoryAdapter;
    private ArrayList<RentalHistoryList> rentalHistoryLists;
    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_rent_history,container, false);
        init();
        return rootView;
    }

    private void init() {
        context = getActivity();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView_rent_hisrory);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        rentalHistoryLists = new ArrayList<>();
        rentalHistoryLists.add(new RentalHistoryList(R.drawable.book5,"Data Capture","₹1500","Forte", "Age 25 to 30","07 June, 2015"));
        rentalHistoryLists.add(new RentalHistoryList(R.drawable.book4,"Product Lunch","₹200","Tom Weaver", "Age 15 to 20","23 June, 2015"));
        rentalHistoryLists.add(new RentalHistoryList(R.drawable.book5,"Connection Culture","₹400","ason Pankau", "Age 11 to 15","15 June, 2015"));
        rentalHistoryLists.add(new RentalHistoryList(R.drawable.book2,"Infinity","₹500","Jenny Smith", "Age 6 to 10","15 Aug, 2015"));
        rentalHistoryLists.add(new RentalHistoryList(R.drawable.book4,"Killing Hemingway","₹1000","Brian D. Meeks", "Age 1 to 5","12 Aug, 2015"));

        recyclerView.setHasFixedSize(true);
        rentalHistoryAdapter = new RentalHistoryAdapter(context, rentalHistoryLists);
        recyclerView.setAdapter(rentalHistoryAdapter);
    }
}
