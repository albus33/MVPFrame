package com.mapshop.net;

import android.content.Context;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Retrofit是Http请求库
 */
public class RetrofitClient {
    public static final int TIME_OUT = 3000;
    private static Retrofit mRetrofit;
    private static Context context;

    private RetrofitClient() {
    }

    private static class SingleTon {
        static RetrofitClient retrofitClient = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return SingleTon.retrofitClient;
    }

    public Retrofit getRetrofitMethod(String url) {
        return getRetrofitMethod(url, TIME_OUT);
    }

    public static void initRetrofit(Context aContext) {
        context = aContext;
    }

    /**
     * @param url
     * @param timeOut
     * @return retrofit 对象
     */
    public Retrofit getRetrofitMethod(String url, int timeOut) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        builder.connectTimeout(timeOut, TimeUnit.SECONDS);
        builder.readTimeout(timeOut, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient client = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())  //添加Gson解析返回值为json格式
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //添加rxJava支持
                .client(client)
                .build();

        return mRetrofit;
    }


    /**
     * @param observable
     * @param <T>
     * @return 返回网络请求回来的数据（返回一个可订阅的事件）
     */
    public <T> Observable<T> call(Observable<RetrofitResult<T>> observable) {
        return Observable.just(observable)
                //判断网络
                .doOnNext(new Action1<Observable<RetrofitResult<T>>>() {
                    @Override
                    public void call(Observable<RetrofitResult<T>> observable) {
//                        if (NetUtil.getNetworkState(context) == 0) {   //没有网络
//                            RetrofitException retrofitException = new RetrofitException();
//                            retrofitException.setStateCode(RetrofitException.NO_NETWORK_CONNECTED);
//                            retrofitException.setMsg(context.getString(R.string.pls_checked_network));
//                            throw retrofitException;
//                        }
                    }
                })
                //在IO线程处理网络连接
                .subscribeOn(Schedulers.io())
                //可在此对获取的事件进行处理（本方法没有处理，直接返回）
                .concatMap(new Func1<Observable<RetrofitResult<T>>, Observable<RetrofitResult<T>>>() {

                    @Override
                    public Observable<RetrofitResult<T>> call(Observable<RetrofitResult<T>> observable) {
                        return observable;
                    }
                })
                //切换到主线程
                .observeOn(AndroidSchedulers.mainThread())
                .concatMap(new Func1<RetrofitResult<T>, Observable<T>>() {

                    @Override
                    public Observable<T> call(RetrofitResult<T> tRetrofitResult) {
                        //处理异常
//                        if (!tRetrofitResult.getSuccess()) {
//                            RetrofitException rException = new RetrofitException();
//                            rException.setStateCode(tRetrofitResult.getSuccess());
//                            rException.setMsg(tRetrofitResult.getErrorMsg());
//                            return Observable.error(rException);
//                        }
                        //发射订阅事件
                        return Observable.just(tRetrofitResult.getData());
                    }
                });
    }


}
