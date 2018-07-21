package com.android.vj.mvparchitecture.view;

public interface LoadingView extends BaseView {
    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();
}
