package com.mapshop.net;

import android.util.Log;

import com.mapshop.modle.CourseBean;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;

public class RetrofitManager {

    public static Observable<List<CourseBean>> getCourseListData(int uId) {
        Observable<RetrofitResult<List<CourseBean>>> observable = RetrofitClient.getInstance()
                .getRetrofitMethod(URL.baseURL)
                .create(IPInter.class)
                .getCourseListData(uId);

        return RetrofitClient.getInstance().call(observable);
    }


    public static void loadMainData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL.baseURL)
//                .addConverterFactory(new Converter.Factory() {
//                    @Override
//                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
////                        return super.responseBodyConverter(type, annotations, retrofit);
//                        return  new Converter<ResponseBody, String>() {
//                            @Override
//                            public String convert(ResponseBody value) throws IOException {
//                                return value.string();
//                            }
//                        };
//                    }
//
//
//
//                })
//
//                .build();
//        IPInter ipInter = retrofit.create(IPInter.class);
//        Call<String > courseList = ipInter.getCourseListData(152);
//        courseList.enqueue(new Callback<String >() {
//            @Override
//            public void onResponse(Call<String > call, Response<String > response) {
//                String  body = response.body();
//                getView().LoadMainDataSuccess(body.toString());
//            }
//
//            @Override
//            public void onFailure(Call<String > call, Throwable t) {
//                Log.i("onFailure",call.toString());
//            }
//        });
    }
}
