package com.ninhttd.devtest.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.andexert.library.RippleView;
import com.ninhttd.devtest.R;

public class PopupHolder {
    private static PopupHolder instance;
    protected DialogActionImpl itemAction;

    public static PopupHolder getInstance() {
        if (instance == null) {
            instance = new PopupHolder();
        }
        return instance;
    }

    private PopupHolder() {

    }
    public AlertDialog showOk(Context context, String title, String message, DialogActionImpl dialogAction) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View dialogView = layoutInflater.inflate(R.layout.popups_ok, null);

        TextView tvMessage = dialogView.findViewById(R.id.tvMessage);
        RippleView btOk = dialogView.findViewById(R.id.btOk);

        final AlertDialog customDialog = new AlertDialog.Builder(context).setView(dialogView).create();
        customDialog.setCanceledOnTouchOutside(false);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(R.drawable.bg_popups));
        customDialog.setOnShowListener(dialog -> {
            AlertDialog alertDialog = (AlertDialog) dialog;
            View view = alertDialog.getWindow().getDecorView().findViewById(R.id.popupOk);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            layoutParams.gravity = Gravity.CENTER;
            view.setLayoutParams(layoutParams);
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        });


        if (message != null)
            tvMessage.setText(message);

        this.itemAction = dialogAction;

        btOk.setOnClickListener(v -> {
            if (itemAction != null) {
                itemAction.execute(context);
            }
            customDialog.dismiss();
        });

        customDialog.show();
        return customDialog;
    }

}
