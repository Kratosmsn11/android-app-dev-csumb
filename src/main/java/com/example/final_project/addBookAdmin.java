package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class addBookAdmin extends AppCompatActivity implements View.OnClickListener{
    private ProjectDatabase db;
    List<Books> getBooks;
    List<allTransactions> trans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_admin);

        View addBtn = findViewById(R.id.btn_book_admin);
        addBtn.setOnClickListener((View.OnClickListener) this);
        db = ProjectDatabase.getInstance(this);
        getBooks = db.BooksDao().getAll();
        trans = db.transDao().getAll();
    }

    @Override
    public void onClick(View view) {
        EditText Name,Author,Genre;
        String name,author, genre;

        boolean check = true;
        int usernameCount = getBooks.size();
        if(view.getId() == R.id.btn_book_admin){
            Log.d("MainActivity", "Button Clicked");
            Name = findViewById(R.id.name);
            name = Name.getText().toString();
            Author = findViewById(R.id.author);
            author = Author.getText().toString();
           Genre = findViewById(R.id.genre);
            genre = Genre.getText().toString();
            for (int i = 0; i < usernameCount; i++) {
                if (getBooks.get(i).getBookName().equals(name)) {
                    String error2 = "This book already exists!";
                    Toast.makeText(addBookAdmin.this, error2, Toast.LENGTH_SHORT).show();
                    check = false;
                }
            }
            if (name.equals("") || author.equals("")|| genre.equals("")){
                String NoText= "Fields cannot be left blank!";
                Toast.makeText(addBookAdmin.this, NoText, Toast.LENGTH_SHORT).show();
                check = false;
            }
            else if (check){
                String msg= "Book Added";
                Toast.makeText(addBookAdmin.this, msg, Toast.LENGTH_SHORT).show();
                Books newBook = new Books(name, author, genre);
                db.BooksDao().addbook(newBook);
                String message = "New Book, Book Name: "+name;
                allTransactions newTransaction = new allTransactions(message);
                db.transDao().addtrans(newTransaction);
                finish();
            }
            else if (!check){
                finish();
            }

        }
    }
}