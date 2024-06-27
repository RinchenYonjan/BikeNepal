package com.example.bikenepal.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikenepal.R;
import com.example.bikenepal.model.BikeModel;
import com.example.bikenepal.recyclerview.RecyclerViewHolder;


import java.util.List;

public class BikeAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;
    List<BikeModel> bikelist;


    // Creating class constructor
    public BikeAdapter(Context context, List<BikeModel> bikelist) {
        this.context = context;
        this.bikelist = bikelist;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_recyclerview_holder, parent, false);
        return new RecyclerViewHolder(view);
    }


    // To display data at the specific position
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.nameView.setText(bikelist.get(position).getName());
        holder.priceView.setText(bikelist.get(position).getPrice());
        holder.fuelView.setText(bikelist.get(position).getFuelTank());
        holder.imageView.setImageResource(bikelist.get(position).getImage());


        holder.urllink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    int currentPosition = holder.getAdapterPosition();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bikelist.get(currentPosition).getUrl()));
                    context.startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(context, "Not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return bikelist.size();
    }

}
