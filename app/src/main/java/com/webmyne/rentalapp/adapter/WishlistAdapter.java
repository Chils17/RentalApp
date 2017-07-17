package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.model.WishList;
import com.webmyne.rentalapp.ui.ProductActivity;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class WishlistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<WishList> wishList;
    private Context context;

    public WishlistAdapter(Context context, ArrayList<WishList> wishList) {
        this.wishList = wishList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wishlist_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.setValues(wishList.get(position));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context, ProductActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wishList.size();
    }


    private class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView bookName, bookPrice, bookAuthor, remove, addCart;
        private ImageView bookImage;

        public MyViewHolder(View view) {
            super(view);
            bookImage = (ImageView) view.findViewById(R.id.imgBook);
            bookName = (TextView) view.findViewById(R.id.txtBookName);
            bookPrice = (TextView) view.findViewById(R.id.txtBookPrice);
            bookAuthor = (TextView) view.findViewById(R.id.txtBookAuthor);
            remove = (TextView) view.findViewById(R.id.txtRemove);
            addCart = (TextView) view.findViewById(R.id.txtMovetoCart);

        }

        public void setValues(WishList wishList) {
            bookImage.setImageResource(wishList.getBookImage());
            bookName.setText(wishList.getBookName());
            bookAuthor.setText(wishList.getBookAuthor());
            bookPrice.setText(wishList.getBookPrice());
        }
    }


}
