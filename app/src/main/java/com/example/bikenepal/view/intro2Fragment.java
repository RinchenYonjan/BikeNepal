package com.example.bikenepal.view;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.bikenepal.R;


public class intro2Fragment extends Fragment {

    private GestureDetector gestureDetector;
    private MainIntroActivity mainIntroActivity;


    // Ensure the hosting activity is an instance of MainIntroActivity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainIntroActivity) {
            mainIntroActivity = (MainIntroActivity) context;
        } else {
            throw new RuntimeException(context.toString() + " must be MainIntroActivity");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro2, container, false);

        gestureDetector = new GestureDetector(getActivity(), new GestureListener());

        // Set a touch listener on the root view
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

        return view;
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }

        public void onSwipeRight() {
            // Call method in MainIntroActivity to go to the previous fragment
            if (mainIntroActivity != null) {
                mainIntroActivity.moveToPreviousFragment();
            }
        }

        public void onSwipeLeft() {
            // Call method in MainIntroActivity to go to the next fragment
            if (mainIntroActivity != null) {
                mainIntroActivity.moveToNextFragment();
            }
        }
    }
}
