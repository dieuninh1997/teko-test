package com.ninhttd.devtest.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.ninhttd.devtest.R;

public class AlertDialogHolder {
    private static AlertDialogHolder instance;

    public static AlertDialogHolder getInstance() {
        if (instance == null) {
            instance = new AlertDialogHolder();
        }
        return instance;
    }

    private AlertDialogHolder() {

    }

    public static AlertDialog show(Context context) {
        LayoutInflater factory = LayoutInflater.from(context);
        final View dialogView = factory.inflate(R.layout.dialog_loading, null);
        ImageView imageLoading = dialogView.findViewById(R.id.imageLoading);

        AlertDialog customDialog = new AlertDialog.Builder(context).setCancelable(false).create();
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.setView(dialogView);

        Glide.with(context).load(R.drawable.img_loading).into(imageLoading);
        customDialog.show();
        return customDialog;
    }
}
