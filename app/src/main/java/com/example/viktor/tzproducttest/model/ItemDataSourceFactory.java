package com.example.viktor.tzproducttest.model;

import android.arch.core.util.Function;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;
import com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad;

import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.isChange;


public class ItemDataSourceFactory extends DataSource.Factory {




    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();

       // itemLiveDataSource.postValue(itemDataSource);



        return itemDataSource;
    }




}
