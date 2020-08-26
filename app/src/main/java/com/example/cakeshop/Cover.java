package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cover extends AppCompatActivity {

    private Button clickMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        clickMenu=findViewById(R.id.click_menu);
        clickMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMenu();
            }
        });

    }
    private void openMenu(){
        Intent intent = new Intent(this, ItemListActivity.class);
        Bundle b = new Bundle();
        b.putString("category", "Cupcakes"); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
    }
}
