package com.example.bikenepal.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikenepal.R;

import java.util.List;

public class BikeAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;

    List<BikeModel> bike;


    public BikeAdapter(Context context, List<BikeModel> bikeModel) {
        this.context = context;
        this.bike = bikeModel;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_recyclerview_holder,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.nameView.setText(bike.get(position).getName());
        holder.priceView.setText(bike.get(position).getPrice());
        holder.fuelView.setText(bike.get(position).getFuelTank());
        holder.imageView.setImageResource(bike.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return bike.size();
    }

}
