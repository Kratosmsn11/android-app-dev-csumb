package com.example.final_project;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {MainData.class, Books.class, allTransactions.class}, version=5, exportSchema = false)

public abstract class ProjectDatabase extends RoomDatabase {

    public abstract MainDao MainDao();
    public abstract BooksDao BooksDao();
    public abstract allTransactionsDao transDao();
    private static ProjectDatabase sInstance;

    public static synchronized ProjectDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    ProjectDatabase.class, "Library.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }


    public void populateInitialData() {

        if(MainDao().count() ==0){
            runInTransaction(()->{
                MainDao().addData(new MainData("bernie", "k3ralaf@n"));
            });
        }

        if(BooksDao().count() ==0){
            runInTransaction(()->{
                BooksDao().addbook(new Books("Angela’s Ashes","Frank McCourt","Memoir"));
                BooksDao().addbook(new Books("The IDA Pro Book","Chris Eagle","Computer Science"));
                BooksDao().addbook(new Books("Frankenstein","Mary Shelley","Fiction"));
            });
        }
    }

}

