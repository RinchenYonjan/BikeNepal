package com.example.bikenepal.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bikenepal.R;
import com.google.android.material.imageview.ShapeableImageView;


public class ProfileFragment extends Fragment {

    ShapeableImageView imageview;
    ImageButton cameraBtn;
    private static final int requestcode = 34;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        cameraBtn = view.findViewById(R.id.cameraButton);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,requestcode);
            }
        });
        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        imageview = getActivity().findViewById(R.id.displayImageView);
        if(requestCode == requestcode)
        {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageview.setImageBitmap(image);
        }
    }


}