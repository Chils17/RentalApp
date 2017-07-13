package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.model.RentalHistoryList;
import com.webmyne.rentalapp.model.WishList;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class RentalHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<RentalHistoryList> rentalHistoryLists;

    public RentalHistoryAdapter(Context context, ArrayList<RentalHistoryList> rentalHistoryLists) {
        this.context = context;
        this.rentalHistoryLists = rentalHistoryLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rental_history_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.setValues(rentalHistoryLists.get(position));
    }

    @Override
    public int getItemCount() {
        return rentalHistoryLists.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView bookName, bookPrice, bookAuthor, bookCategories, bookDeliverTime, bookReturn;
        private ImageView bookImage;
        public MyViewHolder(View view) {
            super(view);
            bookImage = (ImageView) view.findViewById(R.id.imgBook);
            bookName = (TextView) view.findViewById(R.id.txtBookName);
            bookPrice = (TextView) view.findViewById(R.id.txtBookPrice);
            bookAuthor = (TextView) view.findViewById(R.id.txtBookAuthor);
            bookCategories = (TextView) view.findViewById(R.id.txtBookCategorits);
            bookDeliverTime = (TextView) view.findViewById(R.id.txtBookDeliverTime);
            bookReturn = (TextView) view.findViewById(R.id.txtBookReturn);
        }

        public void setValues(RentalHistoryList rentalHistoryList) {
            bookImage.setImageResource(rentalHistoryList.getBookImage());
            bookName.setText(rentalHistoryList.getBookName());
            bookAuthor.setText(rentalHistoryList.getBookAuthor());
            bookPrice.setText(rentalHistoryList.getBookPrice());
            bookCategories.setText(rentalHistoryList.getBookCategories());
            bookDeliverTime.setText(rentalHistoryList.getBookDeliverTime());
        }
    }
}
