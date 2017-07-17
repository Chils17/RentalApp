package com.webmyne.rentalapp.helper;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.Spanned;

/**
 * Created by chintans on 17-07-2017.
 */

public class UIHelper {
    public static OkDialogDismissListener okDialogDismissListener;

    public interface OkDialogDismissListener {
        void onDismiss();
    }
}
