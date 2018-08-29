package com.mapshop.mvpbase;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.mapshop.R;

public abstract class MVPBaseActivity<V extends BaseView, P extends MvpBasePresenter<V>> extends MVPActivity<V, P>
        implements BaseView, View.OnClickListener {
    //加载布局的对象
    protected LayoutInflater inflater;
    //资源对象
    protected Resources resources;
    //上下文环境
    protected Activity context;
    protected FrameLayout frame_content;
    private LinearLayout ll_content;
    private View bodyView;
    private View loadingView;
    private View fail_view;
    protected View titleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 背景不设置任何元素
        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.layout_base_mvp);
        frame_content = (FrameLayout) findViewById(R.id.frame_content);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        inflater = getLayoutInflater();
        resources = getResources();
        context = this;
        initAllView();
        findViews();
        setListener();
        loadData();
    }


    /**
     * 自定义处理标题头的初始化
     */
    private void initAllView() {

        int titleViewId = getTitleViewId();
        if (titleViewId > 0) {
            titleView = inflater.inflate(titleViewId, null);
            ll_content.addView(titleView, 0);
        }

        bodyView = inflater.inflate(getBodyViewId(), null);
        frame_content.addView(bodyView);

        loadingView = inflater.inflate(R.layout.loading_view, null);
        frame_content.addView(loadingView);


        fail_view = inflater.inflate(R.layout.fail_view, null);
        frame_content.addView(fail_view);

        showBodyView();
        findViewById(R.id.iv_back).setOnClickListener(this);
    }

    private void showView(View view) {
        bodyView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        fail_view.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
    }


    protected int getTitleViewId() {
        return R.layout.title;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            onClick(v, id);
        }
    }

    @Override
    public void showBodyView() {
        showView(bodyView);
    }

    @Override
    public void showFailView() {
        showView(fail_view);
    }

    @Override
    public void showLoadingView() {
        showView(loadingView);
    }
}
