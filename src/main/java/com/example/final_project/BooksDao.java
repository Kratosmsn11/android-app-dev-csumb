package com.example.final_project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BooksDao {
    @Insert
    void addbook(Books books);

    @Query("SELECT COUNT(*) FROM bookData")
    int count();

    @Query("SELECT * FROM bookData")
    List<Books> getAll();

    @Delete
    void delete(Books books);

    @Query("delete from bookData where bookName = :title")
    void deleteByTitle(String title);

}
