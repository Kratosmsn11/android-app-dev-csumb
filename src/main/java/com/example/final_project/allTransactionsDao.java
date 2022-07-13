package com.example.final_project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface allTransactionsDao {
    @Insert
    void addtrans(allTransactions transactions);

    @Query("SELECT COUNT(*) FROM TransactionData")
    int count();

    @Query("SELECT * FROM TransactionData")
    List<allTransactions> getAll();

    @Delete
    void delete(allTransactions transactions);
}
