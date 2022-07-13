package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class disp_trans extends AppCompatActivity implements View.OnClickListener{

    private ListView transactionListView;
    private ProjectDatabase db;
    private List<allTransactions> transactionsList;
    private List<String> transaction = new ArrayList<>();
    private ArrayAdapter<allTransactions> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_trans);

        db = ProjectDatabase.getInstance(this);
        transactionsList = db.transDao().getAll();
        transactionListView = findViewById(R.id.transaction_list);
        for (allTransactions t: transactionsList) {
            String tr = t.getTransaction();
            transaction.add(tr);
        }

        adapter = new ArrayAdapter(this,R.layout.trans_disp_list,R.id.list,transaction);
        transactionListView.setAdapter(adapter);

        View addBookYes = findViewById(R.id.yes);
        addBookYes.setOnClickListener((View.OnClickListener) this);

        View addBookNo = findViewById(R.id.no);
        addBookNo.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.yes){
            Intent i = new Intent(this, addBookAdmin.class);
            startActivity(i);
        }
        if (view.getId() == R.id.no){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}