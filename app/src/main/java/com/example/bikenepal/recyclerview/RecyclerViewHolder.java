package com.example.bikenepal.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bikenepal.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView nameView, priceView, fuelView;
    public RelativeLayout urllink;
    Context context;


    // method data view holder
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        fuelView = itemView.findViewById(R.id.fuel);
        urllink = itemView.findViewById(R.id.weblink);

        context = itemView.getContext(); // Get the context from itemView
    }

}
