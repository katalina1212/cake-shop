package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginMethod(View view){
           System.out.println("Login clicked");

        emailText = findViewById(R.id.email_text);
        passwordText = findViewById(R.id.password_text);

       String s1 = emailText.getText().toString();
       int l1 = s1.length();


       if(l1==0){
           Context context = getApplicationContext();
           CharSequence text = "Username cannot be empty";
           int duration = Toast.LENGTH_SHORT;

           Toast toast = Toast.makeText(context, text, duration);
           toast.show();


       }else{
           Intent intent = new Intent (this, PaymentActivity.class);
           startActivity(intent);
       }
    }
}
