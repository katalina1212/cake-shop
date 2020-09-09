package com.example.cakeshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cakeshop.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemListItemAdapter extends ArrayAdapter<Item> {

    private String Category;


    public ItemListItemAdapter(@NonNull Context context, @NonNull List<Item> objects, String Category) {
        super(context,0, objects);
        this.Category = Category;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)

    {
        final Item currentItem = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_item,parent,false);
        TextView itemName = convertView.findViewById(R.id.item_name);
        itemName.setText(currentItem.getName());
        TextView itemPrice = convertView.findViewById(R.id.item_price);
        itemPrice.setText(String.valueOf(currentItem.getPrice()));
        ImageView itemImage = convertView.findViewById(R.id.image);
        Picasso.get().load(currentItem.getLink()).into(itemImage);

        itemName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMenu(getContext(),currentItem.getName() );

            }
        });

        return convertView;
    }


    private void openMenu(Context context, String item){
        Intent intent = new Intent(context, DescriptionActivity.class);
        Bundle b = new Bundle();
        b.putString("item",item); //Your id
        b.putString("category",Category);
        intent.putExtras(b); //Put your id to your next Intent
        context.startActivity(intent);
    }
}
