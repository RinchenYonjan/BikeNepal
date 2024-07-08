package com.example.bikenepal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.bikenepal.R;
import com.example.bikenepal.adapter.IntroPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class MainIntroActivity extends AppCompatActivity {

    CircleIndicator indicator;
    Button skip_Btn;
    Button next_Btn;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intro);

        skip_Btn = findViewById(R.id.skip_text);
        next_Btn = findViewById(R.id.next_text);
        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);

        IntroPagerAdapter adapter = new IntroPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextItem = viewPager.getCurrentItem() + 1;
                if (nextItem < adapter.getCount()) {
                    viewPager.setCurrentItem(nextItem);
                } else {
                    moveToWelcomeActivity();
                }
            }
        });

        skip_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWelcomeActivity();
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                if (position == adapter.getCount() - 1) {
                    next_Btn.setText("Finish");
                    skip_Btn.setVisibility(View.GONE); // Hide the skip button
                } else {
                    next_Btn.setText("Next");
                    skip_Btn.setVisibility(View.VISIBLE); // Show the skip button
                }
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void moveToNextFragment() {
        int nextItem = viewPager.getCurrentItem() + 1;
        if (nextItem < viewPager.getAdapter().getCount()) {
            viewPager.setCurrentItem(nextItem);
        } else {
            moveToWelcomeActivity();
        }
    }


    public void moveToPreviousFragment() {
        int prevItem = viewPager.getCurrentItem() - 1;
        if (prevItem >= 0) {
            viewPager.setCurrentItem(prevItem);
        }
    }


    private void moveToWelcomeActivity() {
        Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

}
