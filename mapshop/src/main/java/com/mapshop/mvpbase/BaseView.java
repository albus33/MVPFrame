package com.mapshop.mvpbase;

import android.view.View;

public interface BaseView extends MvpView {
    int getBodyViewId();

    void findViews();

    void setListener();

    void loadData();

    void onClick(View v, int id);

    void requestFail();

    void showBodyView();

    void showFailView();

    void showLoadingView();


}
