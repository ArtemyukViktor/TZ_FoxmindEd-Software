package com.example.viktor.tzproducttest.model;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.viktor.tzproducttest.Const;
import com.example.viktor.tzproducttest.app.App;
import com.example.viktor.tzproducttest.pojo.pojoproduct.PojoProduct;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;
import com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.gifImageView;

public class ItemDataSource extends PageKeyedDataSource<Integer, Result> {


    String oldCategory;

    public ItemDataSource() {
        this.oldCategory = PlaceholderLoad.category;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Result> callback) {

        if(oldCategory != PlaceholderLoad.category){
            invalidate();
        }


        App.appUmorilli

                .getAnswers(Const.KEY,Const.LIMIT,Const.offset, PlaceholderLoad.category, Const.MainImage)//загрузка с 0 лиса по 20
                .enqueue(new Callback<PojoProduct>() {
                    @Override
                    public void onResponse(Call<PojoProduct> call, Response<PojoProduct> response) {

                        if(response.body() != null){

                            callback.onResult(response.body().getResults(), null, Const.offset + 50);
                            if (response.body().getResults().size() == 50){
                                Log.d("myLogs", "onClick: ");
                                gifImageView.setVisibility(View.INVISIBLE);
                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<PojoProduct> call, Throwable t) {
                        Log.d("myTag", "onFailure: " + t.getMessage());
                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Result> callback) {
        if(oldCategory != PlaceholderLoad.category){
            invalidate();
        }
        App.appUmorilli

                .getAnswers(Const.KEY,Const.LIMIT,params.key, PlaceholderLoad.category,Const.MainImage)
                .enqueue(new Callback<PojoProduct>() {
                    @Override
                    public void onResponse(Call<PojoProduct> call, Response<PojoProduct> response) {

                        if(response.body() != null){
                            Integer key = (params.key > 1) ? params.key - 50 : null;
                            callback.onResult(response.body().getResults(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<PojoProduct> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Result> callback) {
        if(oldCategory != PlaceholderLoad.category){
            invalidate();
        }
        App.appUmorilli

                .getAnswers(Const.KEY,Const.LIMIT,params.key, PlaceholderLoad.category,Const.MainImage)
                .enqueue(new Callback<PojoProduct>() {
                    @Override
                    public void onResponse(Call<PojoProduct> call, Response<PojoProduct> response) {

                        if(response.body() != null){
                            Integer key = response.body().getResults().size() !=  response.body().getCount() ? params.key + 50 : null;
                            callback.onResult(response.body().getResults(), key);
                        }

                    }

                    @Override
                    public void onFailure(Call<PojoProduct> call, Throwable t) {

                    }
                });


    }
}
