package com.webmyne.rentalapp.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.WishList;
import com.webmyne.rentalapp.ui.BaseActivity;
import com.webmyne.rentalapp.ui.ProductActivity;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 12-07-2017.
 */

public class WishlistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<WishList> wishList;
    private BaseActivity context;
    private TfTextView txtNoData;
    private RecyclerView recyclerView;

   /* public WishlistAdapter(BaseActivity context, ArrayList<WishList> wishList) {
        this.wishList = wishList;
        this.context = context;
    }*/

    public WishlistAdapter(BaseActivity context, ArrayList<WishList> wishList, TfTextView txtNoData, RecyclerView recyclerView) {
        this.wishList = wishList;
        this.context = context;
        this.recyclerView = recyclerView;
        this.txtNoData = txtNoData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wishlist_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.setValues(wishList.get(position));
        myViewHolder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("")
                        .setMessage("Are you sure wan't to remove?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                removeWishListData(wishList.get(position));
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();

            }
        });

        if (wishList == null || wishList.size() == 0){
            recyclerView.setVisibility(View.GONE);
            txtNoData.setVisibility(View.VISIBLE);
        }else {
            recyclerView.setVisibility(View.VISIBLE);
        }

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context, ProductActivity.class);
            }
        });
    }

    private void removeWishListData(WishList wishListObject) {
        wishList.remove(wishListObject);
        notifyDataSetChanged();
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
