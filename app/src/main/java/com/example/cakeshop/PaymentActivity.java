package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private TextView totalAmount;
    private TextView paymentType;
    private EditText cardholderText;
    private EditText cardNumberText;
    private EditText validText;
    private EditText cvvText;
    private Button payButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        totalAmount = findViewById(R.id.total_amount);
        paymentType = findViewById(R.id.payment_type);
        cardholderText = findViewById(R.id.cardholder_text);
        cardNumberText = findViewById(R.id.cardnumber_text);
        validText = findViewById(R.id.valid_text);
        cvvText = findViewById(R.id.cvv_text);
        payButton = findViewById(R.id.pay_btn);

        totalAmount.setText("Total amount: $ "+String.valueOf(getIntent().getExtras().getDouble("price")));

        payButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trackingMethod();
            }
        });
    }

    public void trackingMethod() {
        System.out.println("Login clicked");

        String s1 = cardholderText.getText().toString();
        int l1 = s1.length();

        String s2 = cardNumberText.getText().toString();
        int l2 = s2.length();

        String s3 = validText.getText().toString();
        int l3 = s3.length();

        String s4 = cvvText.getText().toString();
        int l4 = s4.length();


        if (l1 == 0 || l2 == 0 || l3 == 0 || l4 ==0) {
            Context context = getApplicationContext();
            CharSequence text = "Field cannot be empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        } else {
            Intent intent = new Intent(this, TrackingMapsActivity.class);
           /* Bundle b = new Bundle();
            b.putDouble("price", item[0].getPrice()); //Your id
            intent.putExtras(b); //Put your id to your next Intent */
            startActivity(intent);
        }
    }
}

