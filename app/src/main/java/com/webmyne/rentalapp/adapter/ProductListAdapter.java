package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.varunest.sparkbutton.SparkButton;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.model.Product;
import com.webmyne.rentalapp.ui.CheckoutOrderActivity;
import com.webmyne.rentalapp.ui.ProductActivity;

import java.util.ArrayList;

import static com.webmyne.rentalapp.R.id.img_like;

/**
 * Created by chiragpatel on 11-07-2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {
    private static ArrayList<Product> productArrayList;
    private Context context;

    public ProductListAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @Override
    public ProductListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.MyViewHolder holder, int position) {
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
        private final RatingBar txtRating;
        private final TextView textAuthor;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            img_like = (SparkButton) itemView.findViewById(R.id.img_like);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textAuthor = (TextView) itemView.findViewById(R.id.textAuthor);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            txtRating = (RatingBar) itemView.findViewById(R.id.txtRating);

        }

        public void setValues(Product product) {
            imgView.setImageResource(product.getImg());
            textName.setText(product.getName());
            textAuthor.setText(product.getAuthor());
            txtPrice.setText(product.getPrice());
            txtRating.setRating(product.getRating());
        }
    }

}
