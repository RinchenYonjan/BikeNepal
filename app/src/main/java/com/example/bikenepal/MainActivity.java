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
import com.example.bikenepal.view.LoginActivity;
import com.example.bikenepal.view.ProfileFragment;
import com.example.bikenepal.view.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener, SettingFragment.OnSettingFragmentInteractionListener {


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

        // Load the preferred theme from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean("dark_mode", false);

        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        // Load the default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
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


    @Override
    public void onToggleTheme() {
        toggleTheme();
    }


    // Call this method to switch between dark mode and light mode
    public void toggleTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean isDarkMode = sharedPreferences.getBoolean("dark_mode", false);

        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            editor.putBoolean("dark_mode", false);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            editor.putBoolean("dark_mode", true);
        }

        editor.apply();
        recreate(); // Recreate activity to apply theme
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
