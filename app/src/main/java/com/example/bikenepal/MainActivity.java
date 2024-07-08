// MainActivity.java
package com.example.bikenepal;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

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

        // Request permissions
        requestNotificationPermission();
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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
        return false;
    }


    private void requestNotificationPermission() {
        boolean notificationPermissionGranted = true;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13 and above
            notificationPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED;
        }

        if (!notificationPermissionGranted) {
            String[] permissions = new String[]{Manifest.permission.POST_NOTIFICATIONS};
            ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            boolean notificationPermissionGranted = true;

            for (int i = 0; i < permissions.length; i++) {
                if (permissions[i].equals(Manifest.permission.POST_NOTIFICATIONS) && grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    notificationPermissionGranted = false;
                    break;
                }
            }

            if (notificationPermissionGranted) {
                // onNotificationPermissionGranted();
            } else {
                Toast.makeText(this, "Notification permission is required for this app to function correctly", Toast.LENGTH_LONG).show();
            }
        }
    }


    private void onNotificationPermissionGranted() {
        // Code to execute when the permission is granted
        Toast.makeText(this, "Notification permissions granted!", Toast.LENGTH_SHORT).show();
    }

}


