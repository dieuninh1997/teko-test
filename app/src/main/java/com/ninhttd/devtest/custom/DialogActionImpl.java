package com.ninhttd.devtest.custom;

import android.content.Context;

public class DialogActionImpl implements DialogAction {
    private Context context;

    public DialogActionImpl() {

    }

    @Override
    public void actionForCancel() {

    }

    @Override
    public void execute(Context context) {

    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return this.context;
    }
}
