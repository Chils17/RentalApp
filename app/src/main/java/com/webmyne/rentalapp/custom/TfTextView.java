package com.webmyne.rentalapp.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.webmyne.rentalapp.R;

public class TfTextView extends android.support.v7.widget.AppCompatTextView {

    private Context _ctx;
    private boolean isBold;
    private int fTypeValue = 0;

    public TfTextView(Context context) {
        super(context);
        if (!isInEditMode()) {
            this._ctx = context;
            init();
        }
    }

    public TfTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TfTextView, 0, 0);
            try {
                isBold = a.getBoolean(R.styleable.TfTextView_isBold, false);

                if (a.hasValue(R.styleable.TfTextView_ftype)) {
                    fTypeValue = a.getInt(R.styleable.TfTextView_ftype, 0);
                }

            } finally {
                a.recycle();
            }

            this._ctx = context;
            init();
        }
    }

    private void init() {
        try {
            setTypeface(Functions.getFontType(getContext(), fTypeValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
