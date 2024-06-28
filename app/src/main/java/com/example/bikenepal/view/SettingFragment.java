package com.example.bikenepal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bikenepal.R;


public class SettingFragment extends Fragment {


    LinearLayout exitButton, themeToggleButton;
    private OnSettingFragmentInteractionListener mListener;
    private boolean isInitialImage = true;


    public interface OnSettingFragmentInteractionListener {
        void onToggleTheme();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        exitButton = view.findViewById(R.id.layoutlogout);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish(); //Closing fragment
                }
                Toast.makeText(getContext().getApplicationContext(), "Logging out!", Toast.LENGTH_LONG).show();
            }
        });


        themeToggleButton = view.findViewById(R.id.themeToggleButton);
        themeToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onToggleTheme();
                }
            }
        });

        return view;
    }
}
