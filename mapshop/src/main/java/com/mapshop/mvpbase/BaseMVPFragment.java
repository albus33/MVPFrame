package com.mapshop.mvpbase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.mapshop.R;

public abstract class BaseMVPFragment<V extends BaseView, P extends BasePresenter<V>> extends MvpFragment<V, P> implements BaseView {

    private View content_view;
    protected View titleView;
    private View bodyView;
    private View loadingView;
    private View fail_view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        content_view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_base_mvp, container, false);
        LinearLayout ll_content = content_view.findViewById(R.id.ll_content);
        FrameLayout frame_content = content_view.findViewById(R.id.frame_content);
        if (getTitleViewId() > 0) {
            titleView = inflater.inflate(getTitleViewId(), null);
            ll_content.addView(titleView, 0);
        }
        bodyView = inflater.inflate(getBodyViewId(), null);
        frame_content.addView(bodyView);

        loadingView = inflater.inflate(R.layout.loading_view, null);
        frame_content.addView(loadingView);

        fail_view = inflater.inflate(R.layout.fail_view, null);
        frame_content.addView(fail_view);

        showBodyView();
        return content_view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        setListener();
        loadData();
    }

    private void showView(View view) {
        bodyView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        fail_view.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
    }

    public void showBodyView() {
        showView(bodyView);
    }

    public void showFailView() {
        showView(fail_view);
    }

    public void showLoadingView() {
        showView(loadingView);
    }

    public abstract int getBodyViewId();

    private int getTitleViewId() {
        return 0;
    }


}
