package com.example.bikenepal.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bikenepal.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, priceView, fuelView;
    RelativeLayout urllink;
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
