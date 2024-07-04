package com.example.bikenepal.controller.retrofit;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bikenepal.MainActivity;
import com.example.bikenepal.model.ContactModel;
import com.example.bikenepal.model.LoginModel;
import com.example.bikenepal.model.UserModel;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient extends AppCompatActivity {

    // Singleton instance for Retrofit
    private static RetrofitClient instance = null;
    private apiservice api;

    public RetrofitClient() {
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://192.168.1.67/API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(apiservice.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    // Method on user register request and response
    public void userRegister(String username, String email, String phonenumber, String password) {
        UserModel userModel = new UserModel(username, email, phonenumber, password);
        Log.d("register", "Initiating user registration");

        Call<UserModel> call = api.register(userModel);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    Log.d("register", "User registered successfully");
                } else {
                    Log.d("register", "Registration failed with response code: " + response.code());
                    try {
                        if (response.errorBody() != null) {
                            Log.d("register", "Error: " + response.errorBody().string());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d("register", "Registration failed: " + t.getMessage());
                Log.d("register", "Request URL: " + call.request().url());
            }
        });
    }

    // Method on user login request and response
    public void loginUser(String username, String password, Activity activity) {
        LoginModel loginModel = new LoginModel(username, password);
        Log.d("login", "Initiating login request");

        Call<LoginModel> loginModelCall = api.login(loginModel);
        loginModelCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    Log.d("login", "Successfully logged in");
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                } else {
                    Log.d("login", "Login request failed with response code: " + response.code());
                    String message;
                    if (response.code() == 401) {
                        message = "Incorrect username or password";
                    } else {
                        message = "Login failed: " + response.message();
                    }
                    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.d("login", "Request URL: " + call.request().url());
                Log.d("login", "Login request failed: " + t.getMessage());
                String message;
                if (t instanceof UnknownHostException) {
                    message = "Server not found";
                } else if (t instanceof ConnectException) {
                    message = "Unable to connect to the server";
                } else if (t instanceof IOException) {
                    message = "Network error";
                } else {
                    message = "Unexpected error occurred";
                }
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method on contact message request and response
    public void contactSend(String company, String country, String name, String description) {
        ContactModel contactModel = new ContactModel(company, country, name, description);
        Log.d("contact register", "Initiating contact user data...");

        Call<ContactModel> Contactcall = api.contact(contactModel);
        Contactcall.enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                if (response.isSuccessful()) {
                    Log.d("contact register", "Contact data registered successfully");
                } else {
                    Log.d("contact register", "Contact registration failed with response code: " + response.code());
                    try {
                        if (response.errorBody() != null) {
                            Log.d("contact register", "Error: " + response.errorBody().string());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ContactModel> call, Throwable t) {
                Log.d("contact register", "Contact registration failed: " + t.getMessage());
                Log.d("contact register", "Request URL: " + call.request().url());
            }
        });
    }
}
