package com.example.project.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project.Model.Product;
import com.example.project.Model.ProductDao;

@Database(entities = {Product.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract ProductDao ProductDao();
}
