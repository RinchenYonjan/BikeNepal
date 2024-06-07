package com.example.bikenepal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bikenepal.view.BikeFragment;
import com.example.bikenepal.view.ContactFragment;
import com.example.bikenepal.view.HomeFragment;
import com.example.bikenepal.view.LoginActivity;
import com.example.bikenepal.view.ProfileFragment;
import com.example.bikenepal.view.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    HomeFragment home = new HomeFragment();

    ProfileFragment profile = new ProfileFragment();

    BikeFragment bike = new BikeFragment();

    ContactFragment contact = new ContactFragment();

    SettingFragment setting = new SettingFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Wake up mobile screen till duration of 2.5 min
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Thread.sleep(150000);

                } catch (InterruptedException ea) {

                    ea.printStackTrace();

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                });

            }

        }).start();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
            return true;

        } else if(item.getItemId() == R.id.profile){

            getSupportFragmentManager().beginTransaction().replace(R.id.container, profile).commit();
            return true;

        } else if (item.getItemId() == R.id.bike) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, bike).commit();
            return true;

        } else if (item.getItemId() == R.id.contact) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, contact).commit();
            return true;

        } else if (item.getItemId() == R.id.setting) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, setting).commit();
            return true;

        }

        return false;
    }


}
