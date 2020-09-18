package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginEntryActivity extends AppCompatActivity {

    private Button loginBtn;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_entry);

        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openLogin();
            }
        });

        registerBtn=findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openRegister();
            }
        });
    }


    private void openLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        Bundle b = new Bundle();
        b.putDouble("price", getIntent().getExtras().getDouble("price")); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
    }


    private void openRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        Bundle b = new Bundle();
        b.putDouble("price", getIntent().getExtras().getDouble("price")); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
    }
}


