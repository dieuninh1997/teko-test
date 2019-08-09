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
    protected DialogActionImpl itemAction;
    protected String message;
    protected String namePositiveButton;
    public AlertDialog alertDialog;
    private static AlertDialogHolder instance;

    public static AlertDialogHolder getInstance() {
        if (instance == null) {
            instance = new AlertDialogHolder();
        }
        return instance;
    }

    private AlertDialogHolder(){

    }
    public static AlertDialog show(Context context){
        LayoutInflater factory=LayoutInflater.from(context);
        final View dialogView=factory.inflate(R.layout.dialog_loading, null);
        ImageView imageLoading=dialogView.findViewById(R.id.imageLoading);

        AlertDialog customDialog=new AlertDialog.Builder(context).setCancelable(false).create();
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.setView(dialogView);

        Glide.with(context).load(R.drawable.img_loading).into(imageLoading);
        customDialog.show();
        return customDialog;
    }

    public void show(Context context, String message, String namePositiveButton){
        if(alertDialog!=null && alertDialog.isShowing()){
            alertDialog.dismiss();
        }

        this.message=message;
        this.namePositiveButton=namePositiveButton;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(message).setCancelable(false).setPositiveButton(namePositiveButton, ((dialog, which) -> dialog.dismiss()));
        alertDialog=alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    public void show(Context context, String message, String namePositiveButton, DialogActionImpl itemAction){
        LogUtils.errorLog(this, "dialog: "+alertDialog);
        if(alertDialog!=null && alertDialog.isShowing()){
            return;
        }
        this.message = message;
        this.namePositiveButton = namePositiveButton;
        this.itemAction = itemAction;
        itemAction.setContext(context);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(namePositiveButton, (dialog, which) -> {
                    dialog.dismiss();
                    itemAction.execute(context);
                });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
