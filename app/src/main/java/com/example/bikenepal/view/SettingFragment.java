package com.example.bikenepal.view;

import static android.content.Context.MODE_PRIVATE;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.bikenepal.R;

public class SettingFragment extends Fragment {


    private ImageView imageView;
    private static final String PREFS_NAME = "theme_prefs";
    private static final String KEY_THEME = "theme";
    private static final String KEY_NOTIFICATIONS_ENABLED = "notifications_enabled";
    private static final String FRAGMENT_TAG = "SettingFragment";
    private boolean isDefaultImage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialization that does not involve the fragment's view hierarchy
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        // Night and Light Mode
        SharedPreferences preferences = requireContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isNightMode = preferences.getBoolean(KEY_THEME, false);

        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        SwitchCompat switchDarkMode = view.findViewById(R.id.themeToggleButton);
        switchDarkMode.setChecked(isNightMode);

        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (getActivity() != null) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(KEY_THEME, isChecked);
                    editor.apply();

                    // Set the theme and recreate activity
                    AppCompatDelegate.setDefaultNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

                    // Recreate the fragment
                    FragmentManager fragmentManager = getParentFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, new SettingFragment(), FRAGMENT_TAG)
                            .commit();
                }
            }
        });


        // Notification
        LinearLayout NotificationButton = view.findViewById(R.id.layoutNotification);
        imageView = view.findViewById(R.id.imageNotification);
        isDefaultImage = preferences.getBoolean(KEY_NOTIFICATIONS_ENABLED, true);
        updateNotificationButtonImage();

        NotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleNotifications();
            }
        });


        // Change Language
        LinearLayout changelanguage = view.findViewById(R.id.layoutChangeLanguage);
        changelanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LanguageActivity.class);
                startActivity(intent);
            }
        });


        // Logout
        LinearLayout LogoutButton = view.findViewById(R.id.layoutLogout);
        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish(); // Closing fragment
                }
                Toast.makeText(requireContext().getApplicationContext(), "Logging out!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }


    // Method to update the notification button image
    private void updateNotificationButtonImage() {
        if (isDefaultImage) {
            imageView.setImageResource(R.drawable.notification);
        } else {
            imageView.setImageResource(R.drawable.notificationoff);
        }
    }


    // turnOffNotification Method
    private void turnOffNotifications() {
        // Cancel all notifications and store their state
        NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            SharedPreferences preferences = requireContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(KEY_NOTIFICATIONS_ENABLED, false);
            editor.apply();

            notificationManager.cancelAll();
            Toast.makeText(requireContext(), "Notifications turned off", Toast.LENGTH_SHORT).show();
        }
    }


    // turnOnNotification Method
    private void turnOnNotifications() {
        // Show a toast for demonstration purposes.
        SharedPreferences preferences = requireContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_NOTIFICATIONS_ENABLED, true);
        editor.apply();

        Toast.makeText(requireContext(), "Notifications turned on", Toast.LENGTH_SHORT).show();
    }


    // toggleNotifications Method
    private void toggleNotifications() {
        SharedPreferences preferences = requireContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean notificationsEnabled = preferences.getBoolean(KEY_NOTIFICATIONS_ENABLED, true);

        if (notificationsEnabled) {
            turnOffNotifications();
        } else {
            turnOnNotifications();
        }
        isDefaultImage = !notificationsEnabled;
        updateNotificationButtonImage();
    }

}
