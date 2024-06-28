package com.example.bikenepal.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bikenepal.R;
import com.example.bikenepal.controller.retrofit.RetrofitClient;
import com.example.bikenepal.model.ContactModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactFragment extends Fragment {

    private EditText companyName, countryName, bikeName, Description;
    private Button sendButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        // Initialize views
        companyName = view.findViewById(R.id.companyname_text);
        countryName = view.findViewById(R.id.countryname_text);
        bikeName = view.findViewById(R.id.bikename_text);
        Description = view.findViewById(R.id.description_text);
        sendButton = view.findViewById(R.id.contact_sendBtn);


        // Set click listener for send button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendContactMessage();
            }
        });

        return view;
    }


    private void sendContactMessage() {
        String company = companyName.getText().toString().trim();
        String country = countryName.getText().toString().trim();
        String name = bikeName.getText().toString().trim();
        String description = Description.getText().toString().trim();

        // Check if fields are empty or not
        if(company.isEmpty() || country.isEmpty() || name.isEmpty() || description.isEmpty()) {

            Toast.makeText(getContext().getApplicationContext(), "Fill is Required", Toast.LENGTH_LONG).show();

        } else {
            // Creating RetrofitClient object to store Contact Page data
            RetrofitClient retrofitClientInstance = new RetrofitClient();
            retrofitClientInstance.contactSend(company, country, name, description);

            // Toast message
            Toast.makeText(getContext().getApplicationContext(), "Request message is Sent!", Toast.LENGTH_LONG).show();
            clearInputFields();
        }

    }


    // Method to text field empty
    private void clearInputFields() {
        companyName.setText("");
        countryName.setText("");
        bikeName.setText("");
        Description.setText("");
    }

}
