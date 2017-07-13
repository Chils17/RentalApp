package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.Shop;
import com.webmyne.rentalapp.ui.ProductListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragpatel on 11-07-2017.
 */

public class ShopCategoryAdapter extends RecyclerView.Adapter<ShopCategoryAdapter.MyViewHolder> {
    private final Context context;
    private List<Shop> shopList;

    public ShopCategoryAdapter(Context context, List<Shop> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopCategoryAdapter.MyViewHolder holder, int position) {
        holder.setValues(shopList.get(position));
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public void setDataList(List<Shop> data) {
        shopList = new ArrayList<>();
        shopList = data;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TfTextView txtName;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtName = (TfTextView) itemView.findViewById(R.id.txtName);
        }

        public void setValues(Shop shop) {
            txtName.setText(shop.getName());
            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Functions.fireIntent(context, ProductListActivity.class);
                }
            });
        }
    }
}
