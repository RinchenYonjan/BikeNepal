package com.example.bikenepal.controller.retrofit;

import com.example.bikenepal.model.ContactModel;
import com.example.bikenepal.model.LoginModel;
import com.example.bikenepal.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiservice {

    // post UserModel data to register.php
    @POST("register.php")
    Call<UserModel> register(@Body UserModel userModel);


    // post LoginModel data to post.php
    @POST("post.php")
    Call<LoginModel> login(@Body LoginModel loginModel);


    // post ContactModel data to contact.php
    @POST("contact.php")
    Call<ContactModel> contact(@Body ContactModel contactModel);

}
