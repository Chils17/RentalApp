package com.webmyne.rentalapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfEditText;
import com.webmyne.rentalapp.custom.TfTextView;

/**
 * Created by chintans on 18-07-2017.
 */

public class BillingAddressFragment extends Fragment {
    //region views
    public static EditText edtaddressshippingbilling;
    public TfTextView tvlabeladdress;

    public BillingAddressFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_address, container, false);
        init(itemView);
        return itemView;
    }

    private void init(View itemView) {
        edtaddressshippingbilling = (EditText) itemView.findViewById(R.id.edt_address_shipping_billing);
        tvlabeladdress = (TfTextView) itemView.findViewById(R.id.tv_label_address);
        tvlabeladdress.setText(getResources().getString(R.string.billing_address));
        edtaddressshippingbilling.setHint(getResources().getString(R.string.hint_enter_billing_address));
    }
}
