package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    private ImageView itemImage;
    private TextView itemName;
    private TextView itemPrice;
    private TextView itemDescription;
    private Button cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        itemImage=findViewById(R.id.item_image);
        itemName=findViewById(R.id.item_name);
        itemPrice=findViewById(R.id.item_price);
        itemDescription=findViewById(R.id.item_description);
        cartBtn=findViewById(R.id.cart_btn);

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
                            dataSnapshot.child("name").getValue(String.class),
                            dataSnapshot.child("description").getValue(String.class),
                            dataSnapshot.child("price").getValue(Integer.class));
                     itemName.setText(item[0].getName());
                     itemPrice.setText(String.valueOf(item[0].getPrice()));
                     itemDescription.setText(item[0].getDescription());



                    // here you can access to name property like university.name

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }
        });
    }

}