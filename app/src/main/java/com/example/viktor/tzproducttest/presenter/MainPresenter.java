package com.example.viktor.tzproducttest.presenter;


import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.viktor.tzproducttest.adapter.SectionsPagerAdapter;
import com.example.viktor.tzproducttest.model.MainModel;
import com.example.viktor.tzproducttest.pojo.pojcategory.PojoProductCategory;
import com.example.viktor.tzproducttest.pojo.pojoproduct.PojoProduct;
import com.example.viktor.tzproducttest.view.activity.MainActivity;
import com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad;
import com.example.viktor.tzproducttest.view.fragment.PlaceholderSave;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

    private static MainPresenter presenter;
    private MainActivity mMainActivity;
    private List<Fragment> fragmentList;
    private List<String> fragmentNamesList;
    private PlaceholderLoad mPlaceholderLoad;
    private PlaceholderSave mPlaceholderSave;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private MainModel mainModel;



    private MainPresenter() {

        fragmentList = new ArrayList<>();
        fragmentNamesList = new ArrayList<>();
        mPlaceholderLoad = PlaceholderLoad.newInstance("Load11");
        mPlaceholderSave = PlaceholderSave.newInstance("Save22");


    }

    public static MainPresenter getPresenterInstance(){
        if(presenter == null){
            presenter = new MainPresenter();
            return presenter;
        }else{
            return presenter;
        }
    }


    public void attach(MainActivity activity){
        mMainActivity = activity;
    }


    public void detach(){
        mMainActivity = null;
    }


    public void setFragmentToPager() {

        getFragmentsList();

        mSectionsPagerAdapter = new SectionsPagerAdapter(mMainActivity.getSupportFragmentManager()
                ,fragmentList,fragmentNamesList);

        mMainActivity.getmViewPager().setAdapter(mSectionsPagerAdapter);
        mMainActivity.getTableLayout().setupWithViewPager( mMainActivity.getmViewPager());



    }

    private void getFragmentsList() {
        fragmentList.clear();
      fragmentList.add(mPlaceholderLoad);
        fragmentList.add(mPlaceholderSave);
        fragmentNamesList.add("load");
        fragmentNamesList.add("save");

    }

    public void getCategories() { mainModel = new MainModel();
       mainModel.getCategories();

    }

    public void setCategories(List<String> list) {

        mPlaceholderLoad.setCategories(list);

    }

    public void updateGridRecycler() {

        mPlaceholderSave.updateRecycler();
//        adapter.setmData(dao.getAllProducts());
//        adapter.notifyDataSetChanged();
//        Log.d("myTag2", "onResume: ");

    }
}
