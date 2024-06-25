package com.example.bikenepal.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bikenepal.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, priceView, fuelView, urlView;
    Context context;

    // data view holder method
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        fuelView = itemView.findViewById(R.id.fuel);
        urlView = itemView.findViewById(R.id.url);

        // To set url textview invisible in mobile screen
        urlView.setVisibility(View.INVISIBLE);

        context = itemView.getContext(); // Get the context from itemView

        urlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming urlView contains the URL text
                String url = urlView.getText().toString();
                gotoUrl(url);
            }
        });
    }

    private void gotoUrl(String s) {
        try {
            Uri uri = Uri.parse(s);
            context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (Exception e) {
            Toast.makeText(context, "Not available", Toast.LENGTH_SHORT).show();
        }
    }
}
