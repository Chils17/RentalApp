package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.model.ProductImage;
import com.webmyne.rentalapp.model.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.MyViewHolder> {
    private final Context context;
    private final OnClickItem onClickItem;
    private List<ProductImage> productImageList;

    public ProductImageAdapter(Context context, List<ProductImage> productImageList, OnClickItem onClickItem) {
        this.context = context;
        this.onClickItem = onClickItem;
        this.productImageList = productImageList;
    }

    @Override
    public ProductImageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ProductImageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductImageAdapter.MyViewHolder holder, final int position) {
        holder.setValues(productImageList.get(position));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productImageList.size();
    }

    public void setDataList(List<ProductImage> data) {
        productImageList = new ArrayList<>();
        productImageList = data;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final ProgressBar progress;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            progress = (ProgressBar) itemView.findViewById(R.id.progress);
        }

        public void setValues(ProductImage productImage) {
           // imageView.setImageResource(productImage.getImg());

            progress.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(productImage.getImg_url())
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            progress.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(imageView);
        }
    }

    public interface OnClickItem {
        void onClickItem(int position);
    }
}
