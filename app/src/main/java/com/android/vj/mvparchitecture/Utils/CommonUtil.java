package com.android.vj.mvparchitecture.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.android.vj.mvparchitecture.R;

public class CommonUtil {
    private static AlertDialog alertDialog;

    public static void showProgressBar(Context context, boolean isCancellable) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View dialogView = inflater.inflate(R.layout.progress_dialog_layout, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(isCancellable);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public static void hideProgressBar() {
        alertDialog.dismiss();
    }
}
