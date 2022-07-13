package com.example.final_project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookData")
public class Books {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "BookName")
    private String BookName;

    @ColumnInfo(name = "Author")
    private String Author;

    @ColumnInfo(name = "Genre")
    private String Genre;

    public Books(String BookName, String Author, String Genre){
        this.BookName = BookName;
        this.Author = Author;
        this.Genre = Genre;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public String toString() {
        return  BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookName() {
        return BookName;
    }
}
