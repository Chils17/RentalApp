package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.model.ShopHistoryList;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class ShopHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ShopHistoryList> historyLists;
    private Context context;

    public ShopHistoryAdapter(Context context, ArrayList<ShopHistoryList> historyLists) {
        this.historyLists = historyLists;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_history_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.setValues(historyLists.get(position));
    }

    @Override
    public int getItemCount() {
        return historyLists.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView bookName, bookPrice, bookAuthor, bookCategories, bookDeliverTime;
        private ImageView bookImage;
        public MyViewHolder(View view) {
            super(view);
            bookImage = (ImageView) view.findViewById(R.id.imgBook);
            bookName = (TextView) view.findViewById(R.id.txtBookName);
            bookPrice = (TextView) view.findViewById(R.id.txtBookPrice);
            bookAuthor = (TextView) view.findViewById(R.id.txtBookAuthor);
            bookCategories = (TextView) view.findViewById(R.id.txtBookCategorits);
            bookDeliverTime = (TextView) view.findViewById(R.id.txtBookDeliverTime);
        }

        public void setValues(ShopHistoryList shopHistoryList) {
            bookImage.setImageResource(shopHistoryList.getBookImage());
            bookName.setText(shopHistoryList.getBookName());
            bookAuthor.setText(shopHistoryList.getBookAuthor());
            bookPrice.setText(shopHistoryList.getBookPrice());
            bookCategories.setText(shopHistoryList.getBookCategories());
            bookDeliverTime.setText(shopHistoryList.getBookDeliverTime());
        }
    }
}
