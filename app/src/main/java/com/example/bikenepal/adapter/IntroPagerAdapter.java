package com.example.bikenepal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bikenepal.view.intro1Fragment;
import com.example.bikenepal.view.intro2Fragment;
import com.example.bikenepal.view.intro3Fragment;

public class IntroPagerAdapter extends FragmentPagerAdapter {

    public IntroPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new intro1Fragment();
            case 1:
                return new intro2Fragment();
            case 2:
                return new intro3Fragment();
            default:
                return new intro1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3; // Number of intro screens
    }
}
