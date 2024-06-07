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
import com.example.bikenepal.recyclerview.BikeModel;
import java.util.ArrayList;
import java.util.List;

public class BikeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_bike, container, false);


        RecyclerView recyclerView = rootView.findViewById(R.id.verticalRecyclerView1);

        List<BikeModel> bike = new ArrayList<BikeModel>();
        bike.add(new BikeModel("Yamaha R15 M BS6", "Price: RS 6,33,900","Fuel Tank: 11L", R.drawable.r1m));
        bike.add(new BikeModel("CBR600RR", "Price: RS 34,50,000", "Fuel Tank: 18L", R.drawable.cbrrr));
        bike.add(new BikeModel("Pulsar N250 Dual ABS", "Price: RS 4,50,000", "Fuel Tank: 14L", R.drawable.n250));
        bike.add(new BikeModel("Yamaha YZF R1", "Price: RS 23,90,000", "Fuel Tank: 17L", R.drawable.r1yamaha));
        bike.add(new BikeModel("Honda CRF 300L", "Price: RS 20,75,000", "Fuel Tank: 7.8L", R.drawable.crf));
        bike.add(new BikeModel("Yamaha MT09", "Price: RS 34,99,000", "Fuel Tank: 14L", R.drawable.mt09));
        bike.add(new BikeModel("Dominor-400 BS6", "Price: RS 5,99,900", "Fuel Tank: 13L", R.drawable.dominor400));
        bike.add(new BikeModel("Honda CBR350RS", "Price: RS 9,75,000", "Fuel Tank: 15L", R.drawable.cbrs350));
        bike.add(new BikeModel("Pulsar NS200 FI DUAL ABS BS6", "Price: RS 4,25,900", "Fuel Tank: 12L", R.drawable.ns200));




        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new BikeAdapter(getContext(), bike));

        return rootView;
    }



}