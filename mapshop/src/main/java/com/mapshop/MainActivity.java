package com.mapshop;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapshop.ActivityPresenter.MainPresenter;
import com.mapshop.adapter.fragmentAdapter;
import com.mapshop.fragment.HomeFragment;
import com.mapshop.fragment.NearbyFragment;
import com.mapshop.modle.CourseBean;
import com.mapshop.mvpView.MainView;
import com.mapshop.mvpbase.MVPBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MVPBaseActivity<MainView,MainPresenter>  implements MainView {
    /*图标*/
    private final int[] images = new int[]{R.drawable.tab_have_class_selector,
          };
//    public final int[] titles = new int[]{R.string.main_index,R.string.nearby,R.string.release,R.string.news,R.string.login};
    public final int[] titles = new int[]{R.string.main_index,R.string.nearby};
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager view_pager;
    private TabLayout tab_layout;
    private View view_line;
    private HomeFragment homeFragment;
    private NearbyFragment nearbyFragment;

    @Override
    public int getBodyViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void findViews() {
        view_pager = findViewById(R.id.view_pager);
        tab_layout = findViewById(R.id.tab_layout);
        view_line = findViewById(R.id.view_line);



        if(titleView!=null){
            titleView.setVisibility(View.GONE);
        }
    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData() {
        setTabs();
        setFragment();
        int userId = 152;
        presenter.loadMainData(userId);
    }

    private void setFragment() {
        fragments.clear();
        if (homeFragment==null){
            homeFragment = new HomeFragment();

        }
        fragments.add(homeFragment);
        if(nearbyFragment==null){
            nearbyFragment = new NearbyFragment();

        }
        fragments.add(nearbyFragment);
        FragmentPagerAdapter fragmentPagerAdapter = new fragmentAdapter(getSupportFragmentManager(),fragments);
        view_pager.setAdapter(fragmentPagerAdapter);
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(view_pager));
    }

    public void setTabs() {
        for (int i = 0; i < titles.length; i++) {
            TabLayout.Tab tab = tab_layout.newTab();
            View view = this.getLayoutInflater().inflate(R.layout.tab_indicator, null);
            view.findViewById(R.id.tab_indicator_icon).setVisibility(View.GONE);
            tab.setCustomView(view);

            TextView tvTitle = view.findViewById(R.id.tab_indicator_hint);
            ImageView imgTab = view.findViewById(R.id.tab_indicator_icon);

                tvTitle.setText(titles[i]);

//            imgTab.setImageResource(images[i]);
            tab_layout.addTab(tab);
        }
    }
    @Override
    public void onClick(View v,int id) {

    }

    @Override
    public void requestFail() {

    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void LoadMainDataSuccess(List<CourseBean> body) {
        view_line.setVisibility(View.GONE);
        Log.i("LoadMainDataSuccess",body.get(0).toString());
    }
}
