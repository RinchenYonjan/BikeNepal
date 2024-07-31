package com.example.bikenepal.view;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.bikenepal.R;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        // Get the dimensions of the parent view (or screen)
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int parentWidth = displayMetrics.widthPixels;
        int parentHeight = displayMetrics.heightPixels;

        // Bike Nepal TextView
        TextView textView = view.findViewById(R.id.BikeNepal_textview);

        // Calculate the margins as a percentage of the parent view's dimensions
        int leftMarginPercentage = 5;  // 5% of the parent view's width
        int topMarginPercentage = 6;  // 10% of the parent view's height
        int rightMarginPercentage = 0;
        int bottomMarginPercentage = 0;

        // Calculate the margin values in pixels
        int leftMargin = (parentWidth * leftMarginPercentage) / 100;
        int topMargin = (parentHeight * topMarginPercentage) / 100;
        int rightMargin = (parentWidth * rightMarginPercentage) / 100;
        int bottomMargin = (parentHeight * bottomMarginPercentage) / 100;

        // Get the LayoutParams of the TextView
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();

        // Set the calculated margins
        layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

        // Apply the new LayoutParams to the TextView
        textView.setLayoutParams(layoutParams);


        
        // Hi! Welcome User TextView
        TextView textView1 = view.findViewById(R.id.WelcomeUser_textview);

        // Calculate the margins as a percentage of the parent view's dimensions
        int leftMarginPercentage1 = 10;  // 10% of the parent view's width
        int topMarginPercentage1 = 2;    // 2% of the parent view's height
        int rightMarginPercentage1 = 0;
        int bottomMarginPercentage1 = 0;

        // Calculate the margin values in pixels
        int leftMargin1 = (parentWidth * leftMarginPercentage1) / 100;
        int topMargin1 = (parentHeight * topMarginPercentage1) / 100;
        int rightMargin1 = (parentWidth * rightMarginPercentage1) / 100;
        int bottomMargin1 = (parentHeight * bottomMarginPercentage1) / 100;

        // Get the LayoutParams of the TextView
        RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) textView1.getLayoutParams();

        // Set the calculated margins
        layoutParams1.setMargins(leftMargin1, topMargin1, rightMargin1, bottomMargin1);

        // Apply the new LayoutParams to the TextView
        textView1.setLayoutParams(layoutParams1);


        return view;
    }

}