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
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.OrderDetail;
import com.webmyne.rentalapp.model.OrderHistory;
import com.webmyne.rentalapp.ui.OrderHDetailActivity;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class ShopHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<OrderDetail> historyLists;
    private Context context;

    public ShopHistoryAdapter(Context context, ArrayList<OrderDetail> historyLists) {
        this.historyLists = historyLists;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.setValues(historyLists.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context, OrderHDetailActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyLists.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private final TfTextView bookId;
        private final TfTextView bookNo;
        private TfTextView bookName, bookPrice, bookAuthor, bookCategories, bookDeliverTime;
        public MyViewHolder(View view) {
            super(view);
            bookName = (TfTextView) view.findViewById(R.id.txtBookName);
            bookId = (TfTextView) view.findViewById(R.id.txtBookId);
            bookPrice = (TfTextView) view.findViewById(R.id.txtBookPrice);
            bookNo = (TfTextView) view.findViewById(R.id.txtBookNo);
            bookDeliverTime = (TfTextView) view.findViewById(R.id.txtBookDeliverTime);
        }

        public void setValues(OrderDetail orderDetail) {
            bookName.setText(orderDetail.getName());
            bookPrice.setText(orderDetail.getPrice());
            bookId.setId(orderDetail.getId());
            bookNo.setText(orderDetail.getBook_no());
            bookDeliverTime.setText(orderDetail.getDate());
        }
    }
}
