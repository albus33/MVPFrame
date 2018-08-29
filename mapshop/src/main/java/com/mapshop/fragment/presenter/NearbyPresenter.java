package com.mapshop.fragment.presenter;

import com.mapshop.fragment.view.NearbyView;
import com.mapshop.modle.CourseBean;
import com.mapshop.mvpbase.BasePresenter;
import com.mapshop.net.BaseObserver;
import com.mapshop.net.RetrofitManager;
import java.util.List;

public class NearbyPresenter extends BasePresenter<NearbyView> {
    public void loadCourseList() {
        RetrofitManager.getCourseListData(709).subscribe(new BaseObserver<List<CourseBean>>(getView()) {
            @Override
            protected void onSuccess(List<CourseBean> courseBeans) {
                getView().getCourseListDataSuccess(courseBeans);
            }

            @Override
            public void onException(Throwable e) {

            }
        });
    }
}
