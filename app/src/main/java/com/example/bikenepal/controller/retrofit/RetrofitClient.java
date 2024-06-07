package com.example.bikenepal.controller.retrofit;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bikenepal.MainActivity;
import com.example.bikenepal.model.ContactModel;
import com.example.bikenepal.model.LoginModel;
import com.example.bikenepal.model.UserModel;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient extends AppCompatActivity {


    // RetrofitClient connection established
    public retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl("http://192.168.1.67/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

            // apiService creation
            apiservice api = retrofit.create(apiservice.class);



    //  userRegister request and response
    public void userRegister(String username, String email, String phonenumber, String password)
    {

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
                    // Optionally, log the response error body
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
                // Log the request URL for debugging
                Log.d("register", "Request URL: " + call.request().url());
            }
        });

    }




    //  loginUser request and response
    public void loginUser(String username, String password, Activity activity)
    {
        LoginModel loginModel = new LoginModel(username, password);
        Log.d("login", "login inresponse");
        Call<LoginModel> loginModelCall = api.login(loginModel);
        loginModelCall.enqueue(new Callback<LoginModel>() {

            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                if(response.isSuccessful())
                {

                    Log.d("login", "successfully login");

                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);

                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

                Log.d("login", "login unsuccessful!");

                System.out.println(call.request().url());

            }
        });
    }




    //  contactSend request and response
    public void contactSend(String username, String address, String job, String description) {

        ContactModel contactModel = new ContactModel(username, address, job, description);
        Log.d("contact register", "Initiating contact user data..");

        Call<ContactModel> call = api.contact(contactModel);
        call.enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                if (response.isSuccessful()) {
                    Log.d("contact register", "Contact data registered successfully");
                } else {
                    Log.d("contact register", "Contact registration failed with response code: " + response.code());
                    // Optionally, log the response error body
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
                // Log the request URL for debugging
                Log.d("contact register", "Request URL: " + call.request().url());
            }
        });

    }

}
