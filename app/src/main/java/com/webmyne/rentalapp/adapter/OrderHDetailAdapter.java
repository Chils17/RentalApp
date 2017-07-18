package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.model.OrderDetail;
import com.webmyne.rentalapp.model.OrderHistory;
import com.webmyne.rentalapp.ui.ProductActivity;

import java.util.ArrayList;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class OrderHDetailAdapter extends RecyclerView.Adapter<OrderHDetailAdapter.MyViewHolder> {
    private ArrayList<OrderHistory> orderHistoryArrayList;
    private Context context;

    public OrderHDetailAdapter(Context context, ArrayList<OrderHistory> orderHistoryArrayList) {
        this.orderHistoryArrayList = orderHistoryArrayList;
        this.context = context;
    }
    @Override
    public OrderHDetailAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_history_item, parent, false);
        return new OrderHDetailAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderHDetailAdapter.MyViewHolder holder, int position) {
        holder.setValues(orderHistoryArrayList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context, ProductActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderHistoryArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView bookName, bookPrice, bookAuthor, bookCategories, bookDeliverTime;
        private ImageView bookImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            bookImage = (ImageView) itemView.findViewById(R.id.imgBook);
            bookName = (TextView) itemView.findViewById(R.id.txtBookName);
            bookPrice = (TextView) itemView.findViewById(R.id.txtBookPrice);
            bookAuthor = (TextView) itemView.findViewById(R.id.txtBookAuthor);
            bookCategories = (TextView) itemView.findViewById(R.id.txtBookCategorits);
            bookDeliverTime = (TextView) itemView.findViewById(R.id.txtBookDeliverTime);
        }

        public void setValues(OrderHistory orderHistory) {
            bookImage.setImageResource(orderHistory.getBookImage());
            bookName.setText(orderHistory.getBookName());
            bookAuthor.setText(orderHistory.getBookAuthor());
            bookPrice.setText(orderHistory.getBookPrice());
            bookCategories.setText(orderHistory.getBookCategories());
            bookDeliverTime.setText(orderHistory.getBookDeliverTime());
        }
    }
}
