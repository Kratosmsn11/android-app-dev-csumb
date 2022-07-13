package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class fiction extends AppCompatActivity implements View.OnClickListener {

    private ProjectDatabase database;
    List<Books> GetBooks;
    List<String> fiction_string = new ArrayList<>();
    private ArrayAdapter<Books> FictionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction);
        View Exit = findViewById(R.id.btn_exit);
        Exit.setOnClickListener(this);

        ListView ListBox3 = findViewById(R.id.fiction_books);
        database = ProjectDatabase.getInstance(this);
        GetBooks = database.BooksDao().getAll();

        for (int i = 0; i < GetBooks.size(); i++) {
                if (GetBooks.get(i).getGenre().equals("Fiction")) {
                String memoirBooks = GetBooks.get(i).getBookName();
                fiction_string.add(memoirBooks);
            }
        }
        if(fiction_string.size()==0){
            Toast.makeText(this, "No books available", Toast.LENGTH_SHORT).show();
        }
        else {
            FictionAdapter = new ArrayAdapter(this, R.layout.mem_list, R.id.memoirbook, fiction_string);
            ListBox3.setAdapter(FictionAdapter);
            ListBox3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem = (String) parent.getItemAtPosition(position);
                    System.out.println("Item is " + selectedItem);
                    Intent Login = new Intent(fiction.this, loginPlaceHold.class);
                    Bundle extraInfo = new Bundle();
                    extraInfo.putString("Title", selectedItem);
                    Login.putExtras(extraInfo);
                    startActivity(Login);
                }
            });
        }

    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_exit) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}