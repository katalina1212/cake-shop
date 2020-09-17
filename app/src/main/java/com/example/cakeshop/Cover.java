package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cover extends AppCompatActivity {

    private Button clickMenu;
    private Button seeUsOnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        clickMenu=findViewById(R.id.click_menu);
        seeUsOnMap=findViewById(R.id.see_us_on_map);

        clickMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMenu();
            }
        });

        seeUsOnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openConnectActivity();
            }
        });

    }
    private void openMenu(){
        Intent intent = new Intent(this, MainActivity.class);
       /* Bundle b = new Bundle();
        b.putString("category", "Cupcakes"); //Your id
        intent.putExtras(b); //Put your id to your next Intent */
        startActivity(intent);
    }

    private void openConnectActivity(){
        Intent intent = new Intent(this, ConnectActivity.class);
       /* Bundle b = new Bundle();
        b.putString("category", "Cupcakes"); //Your id
        intent.putExtras(b); //Put your id to your next Intent */
        startActivity(intent);
    }
}
