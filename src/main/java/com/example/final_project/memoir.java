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

public class memoir extends AppCompatActivity implements View.OnClickListener{

    private ProjectDatabase database;
    List<Books> GetBooks;
    List<String> memoir_string = new ArrayList<>();
    private ArrayAdapter<Books> MemoirAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoir);
        View Exit = findViewById(R.id.btn_exit);
        Exit.setOnClickListener(this);

        ListView ListBox3 = findViewById(R.id.memoir_books);
        database = ProjectDatabase.getInstance(this);
        GetBooks = database.BooksDao().getAll();

        for (int i = 0; i < GetBooks.size(); i++) {
            if (GetBooks.get(i).getGenre().equals("Memoir")) {
                String memoirBooks = GetBooks.get(i).getBookName();
                memoir_string.add(memoirBooks);
            }
        }

        MemoirAdapter = new ArrayAdapter(this, R.layout.mem_list, R.id.memoirbook, memoir_string);
        ListBox3.setAdapter(MemoirAdapter);
        ListBox3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                System.out.println("Item is " + selectedItem);
                Intent Login = new Intent(memoir.this,loginPlaceHold.class);
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