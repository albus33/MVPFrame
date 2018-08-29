package com.mapshop.net;

import com.mapshop.modle.CourseBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface IPInter {

    @FormUrlEncoded
    @POST(URL.COURSE_LIST)
    Observable<RetrofitResult<List<CourseBean>>> getCourseListData(@Field("uId") int uId);

}
