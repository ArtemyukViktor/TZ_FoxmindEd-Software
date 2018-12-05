package com.example.viktor.tzproducttest.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.viktor.tzproducttest.Const;
import com.example.viktor.tzproducttest.model.Dao;
import com.example.viktor.tzproducttest.model.ModelDB.DataBase;
import com.example.viktor.tzproducttest.restclient.AppProduct;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static AppProduct appUmorilli;
    Retrofit retrofit;
    public static DataBase db;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        appUmorilli = retrofit.create(AppProduct.class);

       db = Room.databaseBuilder(getApplicationContext(),DataBase.class,"database")
               .allowMainThreadQueries()
               .build();
    }
    public static AppProduct getAppProduct(){return appUmorilli;}

    public static DataBase getInstanceDB(){
        return db;

    }
}
