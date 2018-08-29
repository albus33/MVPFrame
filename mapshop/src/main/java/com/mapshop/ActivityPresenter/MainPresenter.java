package com.mapshop.ActivityPresenter;

import android.util.Log;

import com.mapshop.modle.CourseBean;
import com.mapshop.mvpView.MainView;
import com.mapshop.mvpbase.BasePresenter;
import com.mapshop.net.BaseObserver;
import com.mapshop.net.RetrofitManager;
import java.util.List;
import rx.Observable;


public class MainPresenter extends BasePresenter<MainView> {
    public void loadMainData(int uid) {

        Observable<List<CourseBean>> courseListData = RetrofitManager.getCourseListData(uid);

        courseListData.subscribe(new BaseObserver<List<CourseBean>>(getView()) {


            @Override
            protected void onSuccess(List<CourseBean> courseBeans) {
                MainView view = getView();
                view.LoadMainDataSuccess(courseBeans);
            }

            @Override
            public void onException(Throwable e) {
                Log.i("onException",e.toString());
            }
        });

    }


}
