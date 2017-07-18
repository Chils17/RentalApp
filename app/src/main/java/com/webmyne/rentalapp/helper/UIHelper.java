package com.webmyne.rentalapp.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.text.Spanned;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by chintans on 17-07-2017.
 */

public class UIHelper {
    public static OkDialogDismissListener okDialogDismissListener;
    public static DialogOptionsSelectedListener dialogOptionsSelectedListener;

    public static void hideKeyPad(Context context, View view) {
        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static boolean isSmallDevice(Context _ctx) {
        double deviceSize = 0f;
        Activity act = (Activity) _ctx;
        Display display = act.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        boolean isSmallDevice = false;

        if (height >= 900) {
            isSmallDevice = false;
        } else {
            isSmallDevice = true;
        }

        return false;
    }

    public static void showMessage(Context mContext, String message, DialogOptionsSelectedListener dialogOptionsSelectedListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog, id) -> {
                    if (dialogOptionsSelectedListener != null)
                        dialogOptionsSelectedListener.onSelect(true);
                    dialog.dismiss();
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public static void showAlertDialogWithYesNo(Context mContext, String message, DialogOptionsSelectedListener dialogOptionsSelectedListener) {
        if (mContext != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, id) -> {
                        if (dialogOptionsSelectedListener != null)
                            dialogOptionsSelectedListener.onSelect(true);
                        dialog.dismiss();
                    })
                    .setNegativeButton("No", (dialog, id) -> {
                        if (dialogOptionsSelectedListener != null)
                            dialogOptionsSelectedListener.onSelect(false);
                        dialog.dismiss();
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
    public static void showAlertDialogWithTwoOpt(Context mContext, String message, DialogOptionsSelectedListener dialogOptionsSelectedListener, String yesOption, String noOption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(yesOption, (dialog, id) -> {
                    if (dialogOptionsSelectedListener != null)
                        dialogOptionsSelectedListener.onSelect(true);
                    dialog.dismiss();
                })
                .setNegativeButton(noOption, (dialog, id) -> {
                    if (dialogOptionsSelectedListener != null)
                        dialogOptionsSelectedListener.onSelect(false);
                    dialog.dismiss();
                });
        AlertDialog alert = builder.create();

        alert.show();
    }
    public static void showAlertDialogWithYesNo(Context mContext, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {
                    if (dialogOptionsSelectedListener != null)
                        dialogOptionsSelectedListener.onSelect(true);
                    dialog.dismiss();
                })
                .setNegativeButton("No", (dialog, id) -> {
                    if (dialogOptionsSelectedListener != null)
                        dialogOptionsSelectedListener.onSelect(false);
                    dialog.dismiss();
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public static void showMessage(Context mContext, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog, id) -> {
                    dialog.dismiss();
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public static void showAlertDialogWithOk(Context mContext, String title, Spanned message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("");
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog, id) -> {
                    if (okDialogDismissListener != null)
                        okDialogDismissListener.onDismiss();
                    dialog.dismiss();
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public static void showAlertDialogWithOk(Context mContext, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("");
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog, id) -> {
                    if (okDialogDismissListener != null)
                        okDialogDismissListener.onDismiss();
                    dialog.dismiss();
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public interface OkDialogDismissListener {
        void onDismiss();
    }
    public interface DialogOptionsSelectedListener {
        void onSelect(boolean isYes);
    }
    public static void setOkDialogDismissListener(OkDialogDismissListener _okDialogDismissListener) {
        okDialogDismissListener = _okDialogDismissListener;
    }

    public static void setDialogOptionsSelectedListener(DialogOptionsSelectedListener _dialogOptionsSelectedListener) {
        dialogOptionsSelectedListener = _dialogOptionsSelectedListener;
    }
}
