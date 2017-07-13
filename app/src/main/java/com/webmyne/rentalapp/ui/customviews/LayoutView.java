package com.webmyne.rentalapp.ui.customviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webmyne.rentalapp.R;

/**
 * Created by chintans on 13-07-2017.
 */

public class LayoutView extends LinearLayout {
    private View view;
    private LinearLayout ll_new_arrivals_content, ll_new_arrivals_content_top, ll_new_arrivals_content_bottom;

    public LayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        init();
    }

    private void init() {
        ll_new_arrivals_content = (LinearLayout) view.findViewById(R.id.ll_new_arrivals_content);
        ll_new_arrivals_content_top = (LinearLayout) view.findViewById(R.id.ll_new_arrivals_content_top);
        ll_new_arrivals_content_bottom = (LinearLayout) view.findViewById(R.id.ll_new_arrivals_content_bottom);
    }
}
