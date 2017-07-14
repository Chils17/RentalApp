package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.MyCart;
import com.webmyne.rentalapp.ui.CheckoutOrderActivity;

import java.util.ArrayList;

import me.himanshusoni.quantityview.QuantityView;

/**
 * Created by chiragpatel on 14-07-2017.
 */

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyViewHolder> {
    private ArrayList<MyCart> myCartArrayList;
    private Context context;

    public MyCartAdapter(Context context, ArrayList<MyCart> myCartArrayList) {
        this.myCartArrayList = myCartArrayList;
        this.context = context;
    }

    @Override
    public MyCartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new MyCartAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCartAdapter.MyViewHolder holder, int position) {
        holder.setValues(myCartArrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return myCartArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TfTextView txtBookName;
        private final TfTextView txtBookPrice;
        private final TfTextView txtBookCategory;
        private final QuantityView numQty;
        private final ImageView imgBook;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgBook = (ImageView) itemView.findViewById(R.id.imgBook);
            txtBookName = (TfTextView) itemView.findViewById(R.id.txtBookName);
            txtBookPrice = (TfTextView) itemView.findViewById(R.id.txtBookPrice);
            txtBookCategory = (TfTextView) itemView.findViewById(R.id.txtBookCategory);
            numQty = (QuantityView) itemView.findViewById(R.id.numQty);
        }

        public void setValues(MyCart myCart) {
            imgBook.setImageResource(myCart.getImage());
            txtBookName.setText(myCart.getName());
            txtBookPrice.setText(myCart.getPrice());
            txtBookCategory.setText(myCart.getCategory());
            numQty.setQuantity(myCart.getQty());
        }
    }
}
