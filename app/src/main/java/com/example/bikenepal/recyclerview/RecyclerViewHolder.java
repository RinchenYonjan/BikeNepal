package com.example.bikenepal.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikenepal.R;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {


    ImageView imageView;

    TextView nameView, priceView, fuelView;


    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        fuelView = itemView.findViewById(R.id.fuel);
    }

}