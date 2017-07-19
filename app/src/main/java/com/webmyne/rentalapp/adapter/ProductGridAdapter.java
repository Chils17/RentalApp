package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.varunest.sparkbutton.SparkButton;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.Product;
import com.webmyne.rentalapp.ui.ProductActivity;

import java.util.ArrayList;

/**
 * Created by chiragpatel on 19-07-2017.
 */

public class ProductGridAdapter extends RecyclerView.Adapter<ProductGridAdapter.MyViewHolder> {
    private ArrayList<Product> productArrayList;
    private Context context;

    public ProductGridAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @Override
    public ProductGridAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductGridAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductGridAdapter.MyViewHolder holder, int position) {
        holder.setValues(productArrayList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context, ProductActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgView;
        private final SparkButton img_like;
        private final TextView textName;
        private final TextView txtPrice;
        private final TfTextView txtRating;
        private final TextView textAuthor;
        private final TfTextView txtReview;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            img_like = (SparkButton) itemView.findViewById(R.id.img_like);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textAuthor = (TextView) itemView.findViewById(R.id.textAuthor);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            txtRating = (TfTextView) itemView.findViewById(R.id.txtRating);
            txtReview = (TfTextView) itemView.findViewById(R.id.txtReview);
        }

        public void setValues(Product product) {
            imgView.setImageResource(product.getImg());
            textName.setText(product.getName());
            textAuthor.setText(product.getAuthor());
            txtPrice.setText(product.getPrice());
            txtRating.setText(product.getRating());
            txtReview.setText(product.getReview());
        }
    }
}
