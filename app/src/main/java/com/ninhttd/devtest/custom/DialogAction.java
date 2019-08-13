package com.ninhttd.devtest.custom;

import android.content.Context;

public interface DialogAction {
    void execute(Context context);
    void setContext(Context context);
    Context getContext();
}
