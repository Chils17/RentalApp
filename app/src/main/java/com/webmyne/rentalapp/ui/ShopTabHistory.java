package com.webmyne.rentalapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.adapter.OrderHDetailAdapter;
import com.webmyne.rentalapp.adapter.ShopHistoryAdapter;
import com.webmyne.rentalapp.model.OrderDetail;
import com.webmyne.rentalapp.model.OrderHistory;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class ShopTabHistory extends Fragment {

    private RecyclerView recyclerView;
    private Context context;
    private ShopHistoryAdapter shopHistoryAdapter;
    private ArrayList<OrderDetail> orderDetails;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_shop_history,container, false);
        init();
        return rootView;
    }

    private void init() {
        context = getActivity();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView_shop_hisrory);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        orderDetails = new ArrayList<>();

        orderDetails.add(new OrderDetail(54, "Killing Hemingway", "12 Aug, 2015", "₹ 200", "1" ));
        orderDetails.add(new OrderDetail(55, "Killing Hemingway", "13 Aug, 2015", "₹ 500", "2" ));
        orderDetails.add(new OrderDetail(56, "Killing Hemingway", "14 Aug, 2015", "₹ 600", "3" ));
        orderDetails.add(new OrderDetail(57, "Killing Hemingway", "15 Aug, 2015", "₹ 700", "4" ));
        orderDetails.add(new OrderDetail(58, "Killing Hemingway", "16 Aug, 2015", "₹ 800", "2" ));
        orderDetails.add(new OrderDetail(59, "Killing Hemingway", "17 Aug, 2015", "₹ 800", "4" ));
        orderDetails.add(new OrderDetail(60, "Killing Hemingway", "18 Aug, 2015", "₹ 2000", "3" ));

       /* orderDetails.add(new OrderDetail(R.drawable.book2,"Killing Hemingway","₹1000","Brian D. Meeks", "Age 1 to 5","12 Aug, 2015"));
        orderDetails.add(new OrderDetail(R.drawable.book3,"Infinity","₹500","Jenny Smith", "Age 6 to 10","15 Aug, 2015"));
        orderDetails.add(new OrderDetail(R.drawable.book5,"Connection Culture","₹400","ason Pankau", "Age 11 to 15","15 June, 2015"));
        orderDetails.add(new OrderDetail(R.drawable.book4,"Product Lunch","₹200","Tom Weaver", "Age 15 to 20","23 June, 2015"));
        orderDetails.add(new OrderDetail(R.drawable.book5,"Data Capture","₹1500","Forte", "Age 25 to 30","07 June, 2015"));*/

        shopHistoryAdapter = new ShopHistoryAdapter(context, orderDetails);
        recyclerView.setAdapter(shopHistoryAdapter);
    }
}
