package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.ui.BaseActivity;

/**
 * Created by DSPL on 08/03/2017.
 */

public class NewArrivalRecyclerAdapter extends RecyclerView.Adapter<NewArrivalRecyclerAdapter.ViewHolder> {
    private Context mContext;
    public ViewHolder viewHolder;
    public int lastPosition = -1;

    public NewArrivalRecyclerAdapter(BaseActivity baseactivity) {
        this.mContext = baseactivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_new_arrivals_adapter, parent, false);
        viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        setAnimation(holder.itemView, position);
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            viewToAnimate.setScaleX(0F);
            viewToAnimate.setScaleY(0F);
            viewToAnimate.animate()
                    .scaleX(1F)
                    .scaleY(1F)
                    .setDuration(300)
                    .setInterpolator(new DecelerateInterpolator());

            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        /*CardView cardview = (CardView) itemView.findViewById(R.id.card_view);
        LinearLayout itemllproductname = (LinearLayout) itemView.findViewById(R.id.item_ll_product_name);
        TfTextView itemtvproductrs = (TfTextView) itemView.findViewById(R.id.item_tv_product_rs);
        TfTextView itemfragmentmyshoptvproductname = (TfTextView) itemView.findViewById(R.id.item_fragment_my_shop_tv_product_name);
        ImageView itemivproduct = (ImageView) itemView.findViewById(R.id.item_iv_product);*/
        ViewHolder(View view) {
            super(view);

        }
    }
}
