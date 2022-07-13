package com.example.final_project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MainDao {

    @Insert
    void addData(MainData mainData);

    @Query("SELECT COUNT(*) FROM customerAccounts")
    int count();

    @Query("SELECT * FROM customerAccounts")
    List<MainData> getAll();

//    @Delete
//    void delete(MainData mainData);
}
