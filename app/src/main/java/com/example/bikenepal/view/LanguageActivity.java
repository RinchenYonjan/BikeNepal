package com.example.bikenepal.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bikenepal.MainActivity;
import com.example.bikenepal.R;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {


    private static final String PREFS_NAME = "app_prefs";
    private static final String KEY_LANGUAGE = "language";

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        String savedLanguage = PreferenceManager.getLanguagePreference(this);

        if (savedLanguage.equals("en")) {
            radioGroup.check(R.id.englishButton);
        } else if (savedLanguage.equals("ne")) {
            radioGroup.check(R.id.nepaliButton);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String languageCode = selectedRadioButton.getTag().toString();
                LocaleHelper.setLocale(LanguageActivity.this, languageCode);
                PreferenceManager.saveLanguagePreference(LanguageActivity.this, languageCode);
            }
        });

        // Back button
        ImageButton backButton = findViewById(R.id.Back_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

//                // Create an instance of the fragment
//                SettingFragment settingFragment = new SettingFragment();
//
//                // Use FragmentManager to add or replace the fragment
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.fragment_container, settingFragment);
//                fragmentTransaction.commit();
            }
        });

        // Save button
        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartActivity();
            }
        });
    }


    // restartActivity Method
    private void restartActivity() {
        Intent intent = new Intent(this, LanguageActivity.class);
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }


    public static class LocaleHelper {
        public static void setLocale(Context context, String languageCode) {
            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);
            Resources resources = context.getResources();
            Configuration config = resources.getConfiguration();

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
        public static void saveLanguagePreference(Context context, String languageCode) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(KEY_LANGUAGE, languageCode);
            editor.apply();
        }

        public static String getLanguagePreference(Context context) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            return prefs.getString(KEY_LANGUAGE, "en");
        }
    }

}
