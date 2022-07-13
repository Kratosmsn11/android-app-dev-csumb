package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.final_project.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<MainData> dataList;
    private ActivityMainBinding binding;
    private ProjectDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = ProjectDatabase.getInstance(this);
        db.populateInitialData();
        dataList = db.MainDao().getAll();

        View createBtn = findViewById(R.id.btn_1);
        createBtn.setOnClickListener(this);

        View placeHold = findViewById(R.id.btn_2);
        placeHold.setOnClickListener(this);

        View manageSys = findViewById(R.id.btn_3);
        manageSys.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_1) {
            Intent i = new Intent(this, CreateAccount.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btn_3){
            Intent i = new Intent(this, ManageActivity.class);
        startActivity(i);
        }

        if (view.getId() == R.id.btn_2){
            Intent i = new Intent(this, placeHold.class);
            startActivity(i);
        }
    }
}