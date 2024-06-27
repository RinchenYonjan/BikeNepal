package com.example.bikenepal.view;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bikenepal.R;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcome_title;
    Button loginpage;
    Button registerpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // Initialize the TextView
        welcome_title = findViewById(R.id.welcometitle);


        // Fading animation
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(welcome_title, "alpha", 1f, 0f);
        fadeOut.setDuration(4000); // Duration in milliseconds
        fadeOut.setRepeatCount(ObjectAnimator.INFINITE);
        fadeOut.setRepeatMode(ObjectAnimator.REVERSE);
        fadeOut.start();


        // redirect to login screen
        loginpage = findViewById(R.id.login_page);
        loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        // redirect to register screen
        registerpage = findViewById(R.id.register_page);
        registerpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}


