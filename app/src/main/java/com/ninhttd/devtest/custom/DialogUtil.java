package com.ninhttd.devtest.custom;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class DialogUtil {
    private AlertDialog alertDialog;
    private static DialogUtil instance;
    private Context context;

    private DialogUtil(Context context) {
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static DialogUtil getInstance(Context context) {
        if (instance == null || instance.context != context) {
            if (instance != null) {
                instance.dismissDialog();
            }
            instance = new DialogUtil(context);
        }
        return instance;
    }

    public void dismissDialog() {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void showDialogLoading() {
        if (alertDialog != null) {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
                return;
            }
            alertDialog.show();
            return;
        }
        alertDialog = AlertDialogHolder.show(context);
    }

}
