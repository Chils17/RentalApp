package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.NumberPicker;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.MyCart;
import com.webmyne.rentalapp.model.RentCart;
import com.webmyne.rentalapp.ui.ProductActivity;

import java.util.ArrayList;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class RentalCartAdapter extends RecyclerView.Adapter<RentalCartAdapter.MyViewHolder> {
    private ArrayList<RentCart> rentCartArrayList;
    private Context context;

    public RentalCartAdapter(Context context, ArrayList<RentCart> rentCartArrayList) {
        this.rentCartArrayList = rentCartArrayList;
        this.context = context;
    }
    @Override
    public RentalCartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rent_item, parent, false);
        return new RentalCartAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RentalCartAdapter.MyViewHolder holder, int position) {
        holder.setValues(rentCartArrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.fireIntent(context, ProductActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rentCartArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgBook;
        private final TfTextView txtBookName;
       // private final TfTextView txtBookAvailable;
        private final TfTextView txtBookCategory;
        private final TfTextView txtBookReturn;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgBook = (ImageView) itemView.findViewById(R.id.imgBook);
            txtBookName = (TfTextView) itemView.findViewById(R.id.txtBookName);
           // txtBookAvailable = (TfTextView) itemView.findViewById(R.id.txtBookAvailable);
            txtBookCategory = (TfTextView) itemView.findViewById(R.id.txtBookCate);
            txtBookReturn = (TfTextView) itemView.findViewById(R.id.txtBookReturn);
        }

        public void setValues(RentCart rentCart) {
            imgBook.setImageResource(rentCart.getImage());
            txtBookName.setText(rentCart.getName());
        //    txtBookAvailable.setText(rentCart.getAvailable());
            txtBookCategory.setText(rentCart.getCate());
            txtBookReturn.setText(rentCart.getRtn());
        }
    }
}
