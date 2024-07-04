// MainActivity.java
package com.example.bikenepal;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.bikenepal.view.BikeFragment;
import com.example.bikenepal.view.ContactFragment;
import com.example.bikenepal.view.HomeFragment;
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
    private static final int PERMISSION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        if (item.getItemId() == R.id.home) {
            selectedFragment = home;
        } else if (item.getItemId() == R.id.profile) {
            selectedFragment = profile;
        } else if (item.getItemId() == R.id.bike) {
            selectedFragment = bike;
        } else if (item.getItemId() == R.id.contact) {
            selectedFragment = contact;
        } else if (item.getItemId() == R.id.setting) {
            selectedFragment = setting;
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
            return true;
        }
        return false;
    }



    private void requestPermissions() {
        boolean cameraPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        boolean notificationPermissionGranted = true;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            notificationPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED;
        }

        if (!cameraPermissionGranted || !notificationPermissionGranted) {
            String[] permissions;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.POST_NOTIFICATIONS};
            } else {
                permissions = new String[]{Manifest.permission.CAMERA};
            }

            ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
        } else {
            // Permissions already granted
            onPermissionsGranted();
        }
    }



    private void onPermissionsGranted() {
        // Code to execute when the permissions are granted
    }
}
