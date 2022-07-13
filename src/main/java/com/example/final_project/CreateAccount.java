package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener{

    private ProjectDatabase db;
    List<MainData> getUser;
    List<allTransactions> trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        View createButton = findViewById(R.id.btn);
        createButton.setOnClickListener((View.OnClickListener) this);
        db = ProjectDatabase.getInstance(this);
        getUser = db.MainDao().getAll();
        trans = db.transDao().getAll();
    }


    @Override
    public void onClick(View view) {
        EditText Username, Password;
        String Usernames, Passwords;

        boolean check = true;
        int usernameCount = getUser.size();
        if(view.getId() == R.id.btn){
            Log.d("MainActivity", "Button Clicked");
            Username = findViewById(R.id.username);
            Usernames = Username.getText().toString();
            Password = findViewById(R.id.password);
            Passwords = Password.getText().toString();
            for (int i = 0; i < usernameCount; i++) {
                if (getUser.get(i).getUsername().equals(Usernames) && getUser.get(i).getPassword().equals(Passwords) ) {
                    Toast.makeText(CreateAccount.this, "The account already exists", Toast.LENGTH_SHORT).show();
                    check = false;
                }
            }
            if (Usernames.equals("") || Passwords.equals("")){
                Toast.makeText(CreateAccount.this, "Username or Password cannot be blank", Toast.LENGTH_SHORT).show();
                check = false;
            }
            else if (Usernames.equals("!admin2")){
                Toast.makeText(CreateAccount.this, "This username is reserved for the Librarian", Toast.LENGTH_SHORT).show();
            }
            else if (check){
                String msg= "Account Created";
                Toast.makeText(CreateAccount.this, msg, Toast.LENGTH_SHORT).show();
                MainData newAccount = new MainData(Usernames, Passwords);
                db.MainDao().addData(newAccount);
               String message = "New Account, Username: "+Usernames;
               allTransactions newTransaction = new allTransactions(message);
               db.transDao().addtrans(newTransaction);
                finish();
            }
        }

    }
}