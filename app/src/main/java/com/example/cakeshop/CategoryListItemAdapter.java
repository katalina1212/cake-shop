package com.example.cakeshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cakeshop.Category;

import java.util.List;

public class CategoryListItemAdapter extends ArrayAdapter<Category> {
    public CategoryListItemAdapter(@NonNull Context context, @NonNull List<Category> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)

    {
        final Category currentItem = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_list_item,parent,false);
        TextView categoryName = convertView.findViewById(R.id.category_name);

        categoryName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMenu(getContext(),currentItem.getName() );

            }
        });

        categoryName.setText(currentItem.getName());
        return convertView;
    }

    private void openMenu(Context context, String category){
        Intent intent = new Intent(context, ItemListActivity.class);
        Bundle b = new Bundle();
        b.putString("category", category); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        context.startActivity(intent);
    }
}




