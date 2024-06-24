package com.example.bikenepal.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikenepal.R;

import java.util.List;

public class BikeAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;
    List<BikeModel> bikelist;


    // Creating class constructor
    public BikeAdapter(Context context, List<BikeModel> bikeModel) {
        this.context = context;
        this.bikelist = bikeModel;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_recyclerview_holder,parent, false));
    }

    // To display data at the specific position
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.nameView.setText(bikelist.get(position).getName());
        holder.priceView.setText(bikelist.get(position).getPrice());
        holder.fuelView.setText(bikelist.get(position).getFuelTank());
        holder.imageView.setImageResource(bikelist.get(position).getImage());
        holder.urlView.setHint(bikelist.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return bikelist.size();
    }

}
