package com.example.bikenepal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bikenepal.R;
import com.example.bikenepal.controller.retrofit.RetrofitClient;

public class LoginActivity extends AppCompatActivity {

    private ImageButton backButton;
    private EditText usernamelogin, passwordlogin;
    private Button loginButton;
    private TextView notRegisteredTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize views
        initializeViews();
        // Set up click listeners
        setUpClickListeners();
    }

    private void initializeViews() {
        usernamelogin = findViewById(R.id.login_username);
        passwordlogin = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        backButton = findViewById(R.id.back_button);
        notRegisteredTextView = findViewById(R.id.notRegister);
    }

    private void setUpClickListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToWelcome();
            }
        });

        notRegisteredTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegister();
            }
        });
    }

    private void handleLogin() {
        String username = usernamelogin.getText().toString().trim();
        String password = passwordlogin.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Username and Password are required", Toast.LENGTH_LONG).show();
        } else {
            // Create RetrofitClient instance and attempt login
            RetrofitClient retrofitClient = new RetrofitClient();
            retrofitClient.loginUser(username, password, LoginActivity.this);
        }
    }

    private void navigateToWelcome() {
        Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(intent);
    }

    private void navigateToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
