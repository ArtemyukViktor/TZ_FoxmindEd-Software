package com.example.viktor.tzproducttest.model;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {

    @Query("SELECT * FROM Result")
    List<Result> getAllProducts();

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
@Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduct(Result result);

    @Delete
    void deleteProduct(Result result);/////////////////////////////////////////////////////

    @Update
    void updateProduct(Result result);

}
