package com.android.vj.mvparchitecture.view;

import android.content.Context;

public interface BaseView {
    Context getContext();

    void showTemporaryMessage(String message);
}
