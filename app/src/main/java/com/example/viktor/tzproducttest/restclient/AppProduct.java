package com.example.viktor.tzproducttest.restclient;

import com.example.viktor.tzproducttest.pojo.pojcategory.PojoProductCategory;
import com.example.viktor.tzproducttest.pojo.pojoproduct.PojoProduct;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AppProduct {
    @GET("/v2/taxonomy/categories?")
    io.reactivex.Observable<PojoProductCategory> getProducts(@Query("api_key") String api_key);

    @GET("/v2/listings/active?")
    Call<PojoProduct> getAnswers(
            @Query("api_key") String api_key,
            @Query("limit") int limit,
            @Query("offset") int offset,
            @Query("category") String category,
            @Query("includes") String includes);


}
