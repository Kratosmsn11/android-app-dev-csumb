package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class compSci extends AppCompatActivity implements View.OnClickListener{

    private ProjectDatabase database;
    List<Books> GetBooks;
    List<String> comp_string = new ArrayList<>();
    private ArrayAdapter<Books> compAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_sci);
        View Exit = findViewById(R.id.btn_exit);
        Exit.setOnClickListener(this);

        ListView ListBox3 = findViewById(R.id.comp_sci_books);
        database = ProjectDatabase.getInstance(this);
        GetBooks = database.BooksDao().getAll();

        for (int i = 0; i < GetBooks.size(); i++) {
            if (GetBooks.get(i).getGenre().equals("Computer Science")) {
                String compBooks = GetBooks.get(i).getBookName();
                comp_string.add(compBooks);
            }
        }

        compAdapter = new ArrayAdapter(this, R.layout.comp_list, R.id.compbook, comp_string);
        ListBox3.setAdapter(compAdapter);
        ListBox3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                System.out.println("Item is " + selectedItem);
                Intent Login = new Intent(compSci.this,loginPlaceHold.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("Title",selectedItem);
                Login.putExtras(extraInfo);
                startActivity(Login);
            }
        });

    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_exit) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}