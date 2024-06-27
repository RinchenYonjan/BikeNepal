package com.example.bikenepal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bikenepal.R;
import com.example.bikenepal.recyclerview.BikeAdapter;
import com.example.bikenepal.model.BikeModel;
import java.util.ArrayList;
import java.util.List;

public class BikeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_bike, container, false);


        RecyclerView recyclerView = rootView.findViewById(R.id.verticalRecyclerView1);

        // creating bikemodel arraylist to save many data in list
        List<BikeModel> bike = new ArrayList<BikeModel>();
        bike.add(new BikeModel("Yamaha R15M BS6", "Price: RS 6,33,900","Fuel Tank: 11L", R.drawable.r15m, "https://www.maw2wheelers.com/motorcycle/r15m/"));
        bike.add(new BikeModel("CBR600RR", "Price: RS 34,50,000", "Fuel Tank: 18L", R.drawable.cbrrr, "https://honda.com.np/motorcycle/cbr600rr/"));
        bike.add(new BikeModel("Pulsar N250", "Price: RS 4,50,000", "Fuel Tank: 14L", R.drawable.pulsarn250, "https://nepal.globalbajaj.com/en/Brands/Pulsar/Pulsar-N250-Nepal"));
        bike.add(new BikeModel("Yamaha YZF R1", "Price: RS 23,90,000", "Fuel Tank: 17L", R.drawable.r1yamaha, "https://yamahamotorsports.com/models/yzf-r1/specs"));
        bike.add(new BikeModel("Honda CRF 300L", "Price: RS 20,75,000", "Fuel Tank: 7.8L", R.drawable.crf, "https://honda.com.np/motorcycle/honda-crf-300l/"));
        bike.add(new BikeModel("Yamaha MT09", "Price: RS 34,99,000", "Fuel Tank: 14L", R.drawable.mt09, "https://yamahamotorsports.com/models/mt-09"));
        bike.add(new BikeModel("Dominar-400 BS6", "Price: RS 5,99,900", "Fuel Tank: 13L", R.drawable.dominor400, "https://nepal.globalbajaj.com/en/Brands/Dominar/Dominar-400-BS6"));
        bike.add(new BikeModel("Honda CBR350RS", "Price: RS 9,75,000", "Fuel Tank: 15L", R.drawable.cbrs350, "https://honda.com.np/motorcycle/cb350rs/"));
        bike.add(new BikeModel("Pulsar NS200 BS6", "Price: RS 4,25,900", "Fuel Tank: 12L", R.drawable.pulsarns200, "https://nepal.globalbajaj.com/en/Brands/Pulsar/Pulsar-NS-200-ABS"));
        bike.add(new BikeModel("Yamaha MT15", "Price: RS 5,24,900", "Fuel Tank: 10L", R.drawable.mt15, "https://www.maw2wheelers.com/motorcycle/mt-15-bs6/"));
        bike.add(new BikeModel("KTM 390 Duke", "Price: RS 8,99,900", "Fuel Tank: 15L", R.drawable.ktm390duke, "https://motoworldnepal.com/shop/ktm-390-duke-new/"));
        bike.add(new BikeModel("Bullet Classic 350", "Price: RS 5,20,000", "Fuel Tank: 13L", R.drawable.bulletclassic350, "https://www.royalenfield.com/np/en/motorcycles/classic-350/"));
        bike.add(new BikeModel("Honda CBR 250R", "Price: RS 6,79,900", "Fuel Tank: 13L", R.drawable.cbr250rcolorwhite, "https://honda.com.np/motorcycle/cbr-250r/"));


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new BikeAdapter(getContext(), bike));

        return rootView;
    }

}