package com.example.cakeshop;

import android.content.Context;
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
    public ItemListItemAdapter(@NonNull Context context, @NonNull List<Item> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)

    {
        Item currentItem = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_item,parent,false);
        TextView itemName = convertView.findViewById(R.id.item_name);
        itemName.setText(currentItem.getName());
        TextView itemPrice = convertView.findViewById(R.id.item_price);
        itemPrice.setText(currentItem.getPrice());
        ImageView itemImage = convertView.findViewById(R.id.category_name);
        Picasso.get().load(currentItem.getLink()).into(itemImage);
        return convertView;
    }
}