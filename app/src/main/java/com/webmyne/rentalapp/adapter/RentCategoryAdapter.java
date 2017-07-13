package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.Functions;
import com.webmyne.rentalapp.custom.TfTextView;
import com.webmyne.rentalapp.model.Rent;
import com.webmyne.rentalapp.model.Shop;
import com.webmyne.rentalapp.ui.ProductListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragpatel on 11-07-2017.
 */

public class RentCategoryAdapter extends RecyclerView.Adapter<RentCategoryAdapter.MyViewHolder> {
    private final Context context;
    private List<Rent> rentList;
    private List<Rent> originalData = null;
    // private ItemFilter mFilter = new ItemFilter();

    public RentCategoryAdapter(Context context, List<Rent> rentList) {
        this.context = context;
        this.rentList = rentList;
        originalData = rentList;
    }

    @Override
    public RentCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false);
        return new RentCategoryAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RentCategoryAdapter.MyViewHolder holder, int position) {
        holder.setValues(rentList.get(position));
    }

    @Override
    public int getItemCount() {
        return rentList.size();
    }

    public void setDataList(ArrayList<Rent> data) {
        rentList = new ArrayList<>();
        rentList = data;
        notifyDataSetChanged();
    }

  /*  @Override
    public Filter getFilter() {
        return mFilter;
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TfTextView txtName;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtName = (TfTextView) itemView.findViewById(R.id.txtName);
        }

        public void setValues(Rent rent) {
            txtName.setText(rent.getName());
            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Functions.fireIntent(context, ProductListActivity.class);

                }
            });
        }
    }

   /* private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final ArrayList<Rent> list = (ArrayList<Rent>) originalData;

            int count = list.size();
            final ArrayList<Rent> nlist = new ArrayList<>(count);

            String filterableString;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).getName();
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(list.get(i));
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            rentList = (ArrayList<Rent>) results.values;
            notifyDataSetChanged();
        }
    }*/
}
