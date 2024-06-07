package com.example.bikenepal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.bikenepal.R;


public class MainIntroActivity extends AppCompatActivity {

    TextView skip_Btn;
    TextView next_Btn;

    intro1Fragment intro1 = new intro1Fragment();
    intro2Fragment intro2 = new intro2Fragment();
    intro3Fragment intro3 = new intro3Fragment();

    // Track the current fragment
    int currentFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intro);

        skip_Btn = findViewById(R.id.skip_text);
        next_Btn = findViewById(R.id.next_text);

        // Load the first fragment initially
        getSupportFragmentManager().beginTransaction().replace(R.id.container1, intro1).commit();


        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToNextFragment();
            }
        });


        skip_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainIntroActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish(); // Optional: close the current activity
            }
        });
    }


    public void moveToNextFragment() {
        Fragment nextFragment;
        switch (currentFragment) {
            case 1:
                nextFragment = intro2;
                currentFragment = 2;
                break;
            case 2:
                nextFragment = intro3;
                currentFragment = 3;
                break;
            case 3:
                Intent intent = new Intent(MainIntroActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
                return;
            default:
                return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container1, nextFragment).commit();
    }


    public void moveToPreviousFragment() {
        Fragment previousFragment;
        switch (currentFragment) {
            case 2:
                previousFragment = intro1;
                currentFragment = 1;
                break;
            case 3:
                previousFragment = intro2;
                currentFragment = 2;
                break;
            default:
                return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container1, previousFragment).commit();
    }

}
