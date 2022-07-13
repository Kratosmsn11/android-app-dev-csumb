package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class loginPlaceHold extends AppCompatActivity implements View.OnClickListener{


    private ProjectDatabase db;
    List<MainData> getUser;
//    TextView user = findViewById(R.id.user);
//    TextView book = findViewById(R.id.book);
//    TextView res = findViewById(R.id.res);
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_place_hold);

        View login = findViewById(R.id.btn_Login);
        login.setOnClickListener((View.OnClickListener) this);
        View btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener((View.OnClickListener) this);
        db = ProjectDatabase.getInstance(this);
        Bundle bun = getIntent().getExtras();
        title = bun.getString("Title");
    }

    @Override
    public void onClick(View view) {
        EditText Username, Password;
        String Usernames, Passwords;
        TextView user = findViewById(R.id.user);
        TextView book = findViewById(R.id.book);
        TextView res = findViewById(R.id.res);

        if (view.getId() == R.id.btn_Login) {
            Username = findViewById(R.id.username);
            Usernames = Username.getText().toString();
            Password = findViewById(R.id.password);
            Passwords = Password.getText().toString();
            getUser = db.MainDao().getAll();

            for (int i = 0; i < getUser.size(); i++) {
                if (getUser.get(i).getUsername().equals(Usernames) && getUser.get(i).getPassword().equals(Passwords)) {
                    Toast.makeText(loginPlaceHold.this, " Login Successful\n Hold placed succesfully", Toast.LENGTH_SHORT).show();
                    db.BooksDao().deleteByTitle(title);
                    user.setText(Usernames);
                    book.setText(title);
                    res.setText("44");
                }
                }

            }
        if(view.getId() == R.id.btn2){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        }
    }
