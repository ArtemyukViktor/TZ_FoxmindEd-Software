package com.example.viktor.tzproducttest.view.activity;

import android.content.pm.ActivityInfo;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.viktor.tzproducttest.R;
import com.example.viktor.tzproducttest.adapter.MyRecyclerViewAdapterGrid;
import com.example.viktor.tzproducttest.adapter.SectionsPagerAdapter;
import com.example.viktor.tzproducttest.app.App;
import com.example.viktor.tzproducttest.model.Dao;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;
import com.example.viktor.tzproducttest.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;  //    coment for git1
    private ViewPager mViewPager;
    public static MainPresenter mMainPresenter;
    private TabLayout tableLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // coment for git2



        initialize();
        initView();

        mMainPresenter.attach(this);

        mMainPresenter.setFragmentToPager();


        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());//presenter

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        // TODO: 01.12.18  //mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if(i == 1){
                    mMainPresenter.updateGridRecycler();
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.container);
        tableLayout = findViewById(R.id.tabs);


    }

    public ViewPager getmViewPager() {
        return mViewPager;
    }

    public TabLayout getTableLayout() {
        return tableLayout;
    }

    private void initialize() {

        mMainPresenter = MainPresenter.getPresenterInstance();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

       mMainPresenter.detach();
        Log.d("myTag", "onDestroy: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
