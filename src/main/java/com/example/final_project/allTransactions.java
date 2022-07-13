package com.example.final_project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Transactiondata")
public class      allTransactions {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="Transactions")
    private String transaction;

    public allTransactions(String transaction){
        this.transaction = transaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
