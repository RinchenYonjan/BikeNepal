package com.example.bikenepal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bikenepal.R;
import com.example.bikenepal.adapter.BikeAdapter;
import com.example.bikenepal.model.BikeModel;
import java.util.ArrayList;
import java.util.List;

public class BikeFragment extends Fragment {

    private List<BikeModel> bikeList;
    private BikeAdapter bikeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bike, container, false);


        SearchView searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


        RecyclerView recyclerView = view.findViewById(R.id.verticalRecyclerView1);

        // creating bikemodel arraylist to save many data in list
        bikeList = new ArrayList<BikeModel>();
        bikeList.add(new BikeModel("Yamaha R15M BS6", "Price: RS 6,33,900","Fuel Tank: 11L", R.drawable.r15m, "https://www.maw2wheelers.com/motorcycle/r15m/"));
        bikeList.add(new BikeModel("Honda CBR600RR", "Price: RS 34,50,000", "Fuel Tank: 18L", R.drawable.cbrrr, "https://honda.com.np/motorcycle/cbr600rr/"));
        bikeList.add(new BikeModel("Pulsar N250", "Price: RS 4,50,000", "Fuel Tank: 14L", R.drawable.pulsarn250, "https://nepal.globalbajaj.com/en/Brands/Pulsar/Pulsar-N250-Nepal"));
        bikeList.add(new BikeModel("Yamaha YZF R1", "Price: RS 23,90,000", "Fuel Tank: 17L", R.drawable.r1yamaha, "https://yamahamotorsports.com/models/yzf-r1/specs"));
        bikeList.add(new BikeModel("Honda CRF 300L", "Price: RS 20,75,000", "Fuel Tank: 7.8L", R.drawable.crf, "https://honda.com.np/motorcycle/honda-crf-300l/"));
        bikeList.add(new BikeModel("Yamaha MT09", "Price: RS 34,99,000", "Fuel Tank: 14L", R.drawable.mt09, "https://yamahamotorsports.com/models/mt-09"));
        bikeList.add(new BikeModel("Dominar-400 BS6", "Price: RS 5,99,900", "Fuel Tank: 13L", R.drawable.dominor400, "https://nepal.globalbajaj.com/en/Brands/Dominar/Dominar-400-BS6"));
        bikeList.add(new BikeModel("Honda CBR350RS", "Price: RS 9,75,000", "Fuel Tank: 15L", R.drawable.cbrs350, "https://honda.com.np/motorcycle/cb350rs/"));
        bikeList.add(new BikeModel("Pulsar NS200 BS6", "Price: RS 4,25,900", "Fuel Tank: 12L", R.drawable.pulsarns200, "https://nepal.globalbajaj.com/en/Brands/Pulsar/Pulsar-NS-200-ABS"));
        bikeList.add(new BikeModel("Yamaha MT15", "Price: RS 5,24,900", "Fuel Tank: 10L", R.drawable.mt15, "https://www.maw2wheelers.com/motorcycle/mt-15-bs6/"));
        bikeList.add(new BikeModel("KTM 390 Duke", "Price: RS 8,99,900", "Fuel Tank: 15L", R.drawable.ktm390duke, "https://motoworldnepal.com/shop/ktm-390-duke-new/"));
        bikeList.add(new BikeModel("Bullet Classic 350", "Price: RS 5,20,000", "Fuel Tank: 13L", R.drawable.bulletclassic350, "https://www.royalenfield.com/np/en/motorcycles/classic-350/"));
        bikeList.add(new BikeModel("Honda CBR 250R", "Price: RS 6,79,900", "Fuel Tank: 13L", R.drawable.cbr250rcolorwhite, "https://honda.com.np/motorcycle/cbr-250r/"));
        bikeList.add(new BikeModel("Kawasaki ZX4R", "Price: RS 15,36,805", "Fuel Tank: 15L", R.drawable.kawasakizx, "https://www.kawasaki.com/en-us/motorcycle/ninja/supersport/ninja-zx-4r"));
        bikeList.add(new BikeModel("KTM 200 Duke", "Price: RS 6,79,900", "Fuel Tank: 13.4L", R.drawable.ktmduke200, "https://motoworldnepal.com/shop/ktm-duke-200/"));
        bikeList.add(new BikeModel("Royal Enfield Hunter 250", "Price: RS 4,79,200", "Fuel Tank: 13L", R.drawable.hunter350, "https://www.royalenfield.com/np/en/motorcycles/hunter-350/"));
        bikeList.add(new BikeModel("Kawasaki H2R", "Price: RS 12,808,451", "Fuel Tank: 17L", R.drawable.kawasakih2r, "https://www.kawasaki.com/en-us/motorcycle/ninja/hypersport/ninja-h2r"));
        bikeList.add(new BikeModel("Aprilla RSV4 1100", "Price: RS 5,011,137", "Fuel Tank: 17.9L", R.drawable.aprillars4, "https://www.aprilia.com/en_EN/models/rsv4/rsv4-factory-1100-4s4v-2023/"));
        bikeList.add(new BikeModel("TVS RTR200 4V", "Price: RS 4,24,900", "Fuel Tank: 12L", R.drawable.tvsrtr200, "https://tvsnepal.com/product/apache-rtr-200-4v-bs6"));
        bikeList.add(new BikeModel("Ducati Panigale V4", "Price: RS 47,00,000", "Fuel Tank: 17L", R.drawable.ducatipanigalev4, "https://ducatiasiapacific.com/nepal/model/new-panigale-v4/"));

        bikeAdapter = new BikeAdapter(getContext(), bikeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(bikeAdapter);

        return view;
    }


    // filterList Method
    private void filterList(String text) {
        List<BikeModel> filteredList = new ArrayList<>();
        for (BikeModel bikeModel : bikeList) {
            if (bikeModel.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(bikeModel);
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(getContext(), "Data not found", Toast.LENGTH_SHORT).show();
        } else {
            bikeAdapter.setFilteredList(filteredList);
        }
    }
}
