package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ShoppingCartActivity extends AppCompatActivity {

    private ImageView shoppingCartImage;
    private TextView cartSubtotal;
    private Button continueShopping;
    private EditText namePay;
    private EditText emailPay;

    private EditText phonePay;
    private EditText addressPay;
    private Button payCard;

    final Item[] item = {null};

    private ShoppingCartActivity thisActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        shoppingCartImage = findViewById(R.id.shopping_cart_image);
        cartSubtotal = findViewById(R.id.cart_subtotal);
        continueShopping = findViewById(R.id.continue_shopping);
        namePay = findViewById(R.id.name_pay);
        emailPay = findViewById(R.id.email_pay);
        phonePay = findViewById(R.id.phone_pay);
        addressPay = findViewById(R.id.address_pay);
        payCard = findViewById(R.id.pay_card);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("categories/"+getIntent().getExtras().getString("category")+"/"+getIntent().getExtras().getString("item"));


        // myRef.setValue("Hello, World!");
        // Read from the database


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                item[0] = new Item(dataSnapshot.getKey(),
                        dataSnapshot.child("description").getValue(String.class),
                        dataSnapshot.child("image").getValue(String.class),
                        dataSnapshot.child("price").getValue(Integer.class));
                Picasso.with(thisActivity).load(item[0].getLink()).into(shoppingCartImage);
                String s1 = "Cart subtotal: \n"+item[0].getName()+" $"+item[0].getPrice();
                cartSubtotal.setText(s1);




                // here you can access to name property like university.name

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }

        });

        continueShopping.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCategories();
            }
        });

        payCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                payMethod();
            }
        });

    }
    private void openCategories(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void payMethod() {
        System.out.println("Login clicked");

        String s1 = namePay.getText().toString();
        int l1 = s1.length();

        String s2 = emailPay.getText().toString();
        int l2 = s2.length();

        String s3 = phonePay.getText().toString();
        int l3 = s3.length();

        String s4 = addressPay.getText().toString();
        int l4 = s4.length();


        if (l1 == 0 || l2 == 0 || l3 == 0 || l4 ==0) {
            Context context = getApplicationContext();
            CharSequence text = "Field cannot be empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        } else {
            Intent intent = new Intent(this, LoginEntryActivity.class);
            Bundle b = new Bundle();
            b.putDouble("price", item[0].getPrice()); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
        }
    }

}
