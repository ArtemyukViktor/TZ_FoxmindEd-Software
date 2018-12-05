package com.example.viktor.tzproducttest.model;

import android.util.Log;

import com.example.viktor.tzproducttest.Const;
import com.example.viktor.tzproducttest.app.App;
import com.example.viktor.tzproducttest.pojo.pojcategory.PojoProductCategory;
import com.example.viktor.tzproducttest.pojo.pojoproduct.PojoProduct;
import com.example.viktor.tzproducttest.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.prefs.PreferenceChangeEvent;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel {

    private List<String> stringList = new ArrayList<>();
    private PojoProductCategory pojoProductCategory;
    private MainPresenter presenter;
    private Disposable disposable;

    public MainModel() {

        presenter = MainPresenter.getPresenterInstance();
    }

    public void getCategories() {


        App.getAppProduct()
                .getProducts(Const.KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojoProductCategory>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PojoProductCategory pojoProductCategory) {
                        for (int i = 0; i < pojoProductCategory.getResults().size(); i++) {
                            stringList.add(pojoProductCategory.getResults().get(i).getName());
                        }
                        presenter.setCategories(stringList);
                    }

                    @Override
                    public void onError(Throwable e) {


                        Log.d("myLog", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}

