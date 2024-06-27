package com.example.bikenepal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bikenepal.R;


public class HomeFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }


    //creating method onclick to go to contact screen
    public void onClick(View view){
        ContactFragment contact = new ContactFragment(); //creating contactFragment object
        FragmentManager fragmentManager = getParentFragmentManager(); //creating fragmentManager object
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //to take from one screen to another
        fragmentTransaction.replace(R.id.container, contact); //replacing homeFragment to contactFragment using activity file(id)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit(); //transaction of screen successful
    }


}