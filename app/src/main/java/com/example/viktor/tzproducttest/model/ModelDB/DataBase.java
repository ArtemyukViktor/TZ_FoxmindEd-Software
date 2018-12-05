package com.example.viktor.tzproducttest.model.ModelDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.viktor.tzproducttest.model.Dao;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;

@Database(entities = {Result.class},version = 5)
public abstract class DataBase extends RoomDatabase {

    //table manager
    public abstract Dao daoProduct();

}
