package com.mapshop.fragment.view;

import com.mapshop.modle.CourseBean;
import com.mapshop.mvpbase.BaseView;

import java.util.List;

public interface NearbyView extends BaseView{
    void getCourseListDataSuccess(List<CourseBean> courseBeans);

}
