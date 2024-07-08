package com.example.bikenepal.view;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bikenepal.R;
import java.util.Locale;


public class LanguageActivity extends AppCompatActivity {


    private static final String PREFS_NAME = "app_prefs";
    private static final String KEY_LANGUAGE = "language";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        // Back
        SettingFragment settingFragment = new SettingFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, settingFragment);
        fragmentTransaction.commit();


        // English
        RadioButton buttonEnglish = findViewById(R.id.englishButton);
        buttonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageCode = "en";
                LocaleHelper.setLocale(LanguageActivity.this, languageCode);
                PreferenceManager.saveLanguagePreference(LanguageActivity.this, languageCode);
                restartActivity();
            }
        });


        // Nepali
        RadioButton buttonNepali = findViewById(R.id.nepaliButton);
        buttonNepali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageCode = "np";
                LocaleHelper.setLocale(LanguageActivity.this, languageCode);
                PreferenceManager.saveLanguagePreference(LanguageActivity.this, languageCode);
                restartActivity();
            }
        });

    }


    // restartActivity Method
    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


    public static class LocaleHelper {

        // changeLanguage Method
        public static void setLocale(Context context, String languageCode) {
            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);
            Resources resources = context.getResources();
            Configuration config = new Configuration(resources.getConfiguration());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                config.setLocale(locale);
                context.createConfigurationContext(config);
            } else {
                config.locale = locale;
                resources.updateConfiguration(config, resources.getDisplayMetrics());
            }
        }
    }


    public static class PreferenceManager {

        //
        public static void saveLanguagePreference(Context context, String languageCode) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(KEY_LANGUAGE, languageCode);
            editor.apply();
        }

        //
        public static String getLanguagePreference(Context context) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            return prefs.getString(KEY_LANGUAGE, "en"); // default to English
        }
    }

}
