package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class placeHold extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_hold);

        View memoir = findViewById(R.id.btn_mem);
        memoir.setOnClickListener(this);

        View cs = findViewById(R.id.btn_cs);
        cs.setOnClickListener(this);

        View fiction = findViewById(R.id.btn_f);
        fiction.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_mem) {
            Intent i = new Intent(this, memoir.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btn_cs){
            Intent i = new Intent(this, compSci.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btn_f){
            Intent i = new Intent(this, fiction.class);
            startActivity(i);
        }
    }
}