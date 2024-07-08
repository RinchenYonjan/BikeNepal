package com.example.bikenepal.view;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bikenepal.R;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // Initialize the TextView
        ImageView icon = findViewById(R.id.image_icon);

        // Fading animation
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(icon, "alpha", 1f, 0f);
        fadeOut.setDuration(1000); // Duration in milliseconds
        fadeOut.setRepeatCount(ObjectAnimator.INFINITE);
        fadeOut.setRepeatMode(ObjectAnimator.REVERSE);
        fadeOut.start();


        // method post delayed
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainIntroActivity.class);
                startActivity(intent);
                finish(); // Finish SplashActivity activity to prevent going back1 to it
            }
        }, 2000);   //1.5 sec
    }

}