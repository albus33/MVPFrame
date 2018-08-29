package com.mapshop.fragment;

import android.view.View;

import com.mapshop.R;
import com.mapshop.mvpbase.BaseMVPFragment;
import com.mapshop.mvpbase.BasePresenter;
import com.mapshop.mvpbase.BaseView;

public class HomeFragment extends BaseMVPFragment<BaseView,BasePresenter<BaseView>> {
    @Override
    public int getBodyViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void findViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void requestFail() {

    }

    @Override
    public BasePresenter<BaseView> createPresenter() {
        return new BasePresenter();
    }
}
