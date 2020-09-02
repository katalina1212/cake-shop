package com.example.cakeshop;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    private ListView itemList;
    private ItemListActivity thisActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        itemList = findViewById(R.id.item_list);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("categories/"+getIntent().getExtras().getString("category"));

        final List<Item> items = new ArrayList<>();

        // myRef.setValue("Hello, World!");
        // Read from the database

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Item item = new Item(postSnapshot.getKey(),
                            postSnapshot.child("name").getValue(String.class),
                            postSnapshot.child("description").getValue(String.class),
                            postSnapshot.child("price").getValue(Integer.class));
                    items.add(item);

                    // here you can access to name property like university.name

                }
                itemList.setAdapter(new ItemListItemAdapter(thisActivity, items));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }
        });



        /*items.add(new Category("Cupcakes"));
        items.add(new Category("Chocolate cakes"));
        items.add(new Category("Birthday cakes")); */




        /*FirebaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View v) {
                 // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

               // myRef.setValue("Hello, World!");
                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        Log.d("Firebase", "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Firebase", "Failed to read value.", error.toException());
                    }
                });
            }
        }); */

    }

}
