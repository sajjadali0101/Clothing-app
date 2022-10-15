package com.example.project.Model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao
{
    @Insert
    void insertrecord(Product product);


    @Query("SELECT COUNT(*) FROM Product WHERE pid = :productid")
    Integer is_exist(int productid);


    @Query("SELECT * FROM Product")
    List<Product> getallproduct();

    @Query("DELETE FROM Product WHERE pid = :id")
    void deleteById(int id);
}
