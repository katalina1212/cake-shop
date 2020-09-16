package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

        final Item[] item = {null};

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
                String s1 = item[0].getName()+" "+item[0].getPrice();
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

    }
    private void openCategories(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
