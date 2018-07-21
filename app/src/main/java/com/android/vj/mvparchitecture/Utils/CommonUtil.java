package com.android.vj.mvparchitecture.Utils;

import android.content.Context;
import android.support.v4.widget.ContentLoadingProgressBar;

class CommonUtil {
    public static ContentLoadingProgressBar contentLoadingProgressBar;

    public static void showProgressBar(Context context) {
        contentLoadingProgressBar = new ContentLoadingProgressBar(context);
        /*contentLoadingProgressBar.setActivated(true);
        contentLoadingProgressBar.setIndeterminate(true);
        contentLoadingProgressBar.onAttachedToWindow();*/
        contentLoadingProgressBar.show();
    }

    public static void hideProgressBar() {
        contentLoadingProgressBar.hide();
    }
}
