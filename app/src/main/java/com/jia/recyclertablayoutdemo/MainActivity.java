package com.jia.recyclertablayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jia.recyclertablayoutdemo.recyclertab.MyPagerAdapter;
import com.jia.recyclertablayoutdemo.recyclertab.RecyclerTabLayout;
import com.jia.recyclertablayoutdemo.recyclertab.TabMenuBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerTabLayout mRecyclerTabLayout;
    private ViewPager mViewPager;
    private MyPagerAdapter mPagerAdapter;

    private List<Fragment> mFragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerTabLayout = findViewById(R.id.recycler_tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        final List<TabMenuBean> tabList = new ArrayList<>();
        TabMenuBean menu1 = new TabMenuBean("本馆介绍");
        TabMenuBean menu2 = new TabMenuBean("图书");
//        TabMenuBean menu3 = new TabMenuBean("电子书");
//        TabMenuBean menu4 = new TabMenuBean("开放时间");
//        TabMenuBean menu5 = new TabMenuBean("本馆资讯");
//        TabMenuBean menu6 = new TabMenuBean("读者留言");

        tabList.add(menu1);
        tabList.add(menu2);
//        tabList.add(menu3);
//        tabList.add(menu4);
//        tabList.add(menu5);
//        tabList.add(menu6);

        mFragmentList.add(new TestFragment());
        mFragmentList.add(new TestFragment());
//        mFragmentList.add(new TestFragment());
//        mFragmentList.add(new TestFragment());
//        mFragmentList.add(new TestFragment());
//        mFragmentList.add(new TestFragment());

        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragmentList, tabList);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(6);
        mRecyclerTabLayout.setUpWithViewPager(tabList, mViewPager);
    }
}
