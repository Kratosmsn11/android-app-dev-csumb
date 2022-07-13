package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener{

    private ProjectDatabase db;
    List<allTransactions> getMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        View Login = findViewById(R.id.btn_login);
        Login.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            EditText Username, Password;
            String Usernamea, Passworda;

            Username = findViewById(R.id.usernamea);
            Usernamea = Username.getText().toString();
            Password = findViewById(R.id.passworda);
            Passworda = Password.getText().toString();

            if(Usernamea.equals("!admin2") && Passworda.equals("!admin2")){
                Intent i = new Intent(this, disp_trans.class);
                startActivity(i);
            }
            else{
                Toast.makeText(ManageActivity.this, "Credentials Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}