package com.mapshop.fragment;

import android.util.Log;
import android.view.View;

import com.mapshop.R;
import com.mapshop.fragment.presenter.NearbyPresenter;
import com.mapshop.fragment.view.NearbyView;
import com.mapshop.modle.CourseBean;
import com.mapshop.mvpbase.BaseMVPFragment;

import java.util.List;

public class NearbyFragment extends BaseMVPFragment<NearbyView, NearbyPresenter> implements NearbyView {
    @Override
    public int getBodyViewId() {
        return R.layout.fragment_nearby;
    }

    @Override
    public void findViews() {

    }


    @Override
    public void setListener() {

    }

    @Override
    public void loadData() {
        presenter.loadCourseList();
    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void requestFail() {

    }

    @Override
    public NearbyPresenter createPresenter() {
        return new NearbyPresenter();
    }

    @Override
    public void getCourseListDataSuccess(List<CourseBean> courseBeans) {
        Log.i("getCourseList",courseBeans.get(0).toString());
    }
}
