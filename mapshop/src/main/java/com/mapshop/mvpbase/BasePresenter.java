package com.mapshop.mvpbase;

import rx.subscriptions.CompositeSubscription;

public class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {
    //线程安全，由所有订阅者组成的组，在页面销毁的时候统一取消所有订阅，防止内存泄露
    public CompositeSubscription mCompositeSubscription;


    @Override
    public void attachView(V view) {
        super.attachView(view);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription = null;
        }
    }

}
