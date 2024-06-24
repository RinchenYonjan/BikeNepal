package com.example.bikenepal.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bikenepal.R;
import com.example.bikenepal.controller.retrofit.RetrofitClient;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerUsername, registerEmail, registerPassword, registerPhoneNumber;
    private CheckBox registerTerms;
    private Button registerButton;
    private ImageButton backButton;
    private TextView alreadyRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsername = findViewById(R.id.register_username);
        registerEmail = findViewById(R.id.register_email);
        registerPhoneNumber = findViewById(R.id.register_phonenumber);
        registerPassword = findViewById(R.id.register_password);
        registerTerms = findViewById(R.id.register_terms);

        registerButton = findViewById(R.id.register_button);
        backButton = findViewById(R.id.back_button);
        alreadyRegistered = findViewById(R.id.alreadyRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToWelcome();
            }
        });

        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

    private void registerUser() {
        String username = registerUsername.getText().toString().trim();
        String email = registerEmail.getText().toString().trim();
        String phonenumber = registerPhoneNumber.getText().toString().trim();
        String password = registerPassword.getText().toString().trim();
        boolean termsAccepted = registerTerms.isChecked();

        if (isInputValid(username, email, phonenumber, password, termsAccepted)) {
            RetrofitClient retrofitClientInstance = new RetrofitClient();
            retrofitClientInstance.userRegister(username, email, phonenumber, password);
            Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_LONG).show();
            clearInputFields();
        }
    }

    private boolean isInputValid(String username, String email, String phoneNumber, String password, boolean termsAccepted) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(getApplicationContext(), "Username is required", Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(getApplicationContext(), "Valid email is required", Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(phoneNumber) || !Patterns.PHONE.matcher(phoneNumber).matches()) {
            Toast.makeText(getApplicationContext(), "Valid phone number is required", Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(password) || password.length() < 5) {
            Toast.makeText(getApplicationContext(), "Password must be at least 5 characters long", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!termsAccepted) {
            Toast.makeText(getApplicationContext(), "You must agree to the terms and conditions", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    // Method to Activity Login
    private void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    // Method to Activity Welcome
    private void navigateToWelcome() {
        Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

    // Method to text field empty
    private void clearInputFields() {
        registerUsername.setText("");
        registerEmail.setText("");
        registerPhoneNumber.setText("");
        registerPassword.setText("");
        registerTerms.setText("");
    }
}
