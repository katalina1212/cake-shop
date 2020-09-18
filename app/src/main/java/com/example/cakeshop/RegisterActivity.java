package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;
    private EditText repasswordText;
    private Button registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn=findViewById(R.id.register_btn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registerMethod();
            }
        });
    }
    public void registerMethod(){
        System.out.println("Login clicked");

        emailText = findViewById(R.id.email_text);
        passwordText = findViewById(R.id.password_text);
        repasswordText = findViewById(R.id.re_password_text);

        String s1 = emailText.getText().toString();
        int l1 = s1.length();

        String s2 = passwordText.getText().toString();
        int l2 = s2.length();

        String s3 = repasswordText.getText().toString();
        int l3 = s3.length();


        if(l1==0 || l2 == 0 || l3 == 0 ){
            Context context = getApplicationContext();
            CharSequence text = "Field cannot be empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }else{
            Intent intent = new Intent (this, PaymentActivity.class);
            Bundle b = new Bundle();
            b.putDouble("price", getIntent().getExtras().getDouble("price")); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
        }
    }
}
