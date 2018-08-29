package com.mapshop.net;


import com.mapshop.mvpbase.BaseView;

import rx.Observer;

public abstract class BaseObserver<T> implements Observer<T> {

    private BaseView baseView;


    public BaseObserver(BaseView view) {
        baseView = view;
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onNext(T t) {
        if (baseView != null) {
            baseView.showBodyView();
        }
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        if (baseView != null) {
            baseView.showFailView();

        }
        onException(e);

    }

    protected abstract void onSuccess(T t);

    public abstract void onException(Throwable e);


}
