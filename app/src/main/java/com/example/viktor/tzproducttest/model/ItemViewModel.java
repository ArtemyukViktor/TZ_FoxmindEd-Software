package com.example.viktor.tzproducttest.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import android.util.Log;

import com.example.viktor.tzproducttest.Const;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;

public class ItemViewModel extends ViewModel {

    LiveData<PagedList<Result>> itemPagedList;

    ItemDataSourceFactory itemDataSourceFactory;
    PagedList.Config config;

    public ItemViewModel() {

        itemDataSourceFactory = new ItemDataSourceFactory();


        config =(new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(Const.LIMIT)
                        .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();


    }

    public LiveData<PagedList<Result>> getItemPagedList() {
        return itemPagedList;
    }



    public void setItemPagedList(){


        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();///создание нового PagingList
    }


}
