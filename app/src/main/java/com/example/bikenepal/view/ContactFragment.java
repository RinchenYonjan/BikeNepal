package com.example.bikenepal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bikenepal.R;
import com.example.bikenepal.controller.retrofit.RetrofitClient;

    public class ContactFragment extends Fragment {

        private EditText contactName, contactAddress, contactJob, contactDescription;
        private Button sendButton;

        public ContactFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_contact, container, false);

            // Initialize views
            contactName = view.findViewById(R.id.contactname_text);
            contactAddress = view.findViewById(R.id.contactaddress_text);
            contactJob = view.findViewById(R.id.job_text);
            contactDescription = view.findViewById(R.id.contactdescription_text);
            sendButton = view.findViewById(R.id.contact_sendBtn);

            // Set click listener for send button
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username = contactName.getText().toString();
                    String address = contactAddress.getText().toString();
                    String job = contactJob.getText().toString();
                    String description = contactDescription.getText().toString();

                    // check if fields are empty or not
                    if(username.isEmpty() || address.isEmpty() || job.isEmpty() || description.isEmpty()) {

                        Toast.makeText(getContext().getApplicationContext(), "Fill is Required", Toast.LENGTH_LONG).show();

                    } else {

                    // Creating RetrofitClient object to store Contact Page data
                    RetrofitClient retrofitClientInstance = new RetrofitClient();
                    retrofitClientInstance.contactSend(username, address, job, description);

                    // Toast message
                    Toast.makeText(getContext().getApplicationContext(), "Request message is Sent!", Toast.LENGTH_LONG).show();

                    }
                }
            });

            return view;

        }
    }



