package com.mapshop.mvpView;

import com.mapshop.modle.CourseBean;
import com.mapshop.mvpbase.BaseView;

import java.util.List;

public interface  MainView extends BaseView {
    void LoadMainDataSuccess(List<CourseBean> body);
}
