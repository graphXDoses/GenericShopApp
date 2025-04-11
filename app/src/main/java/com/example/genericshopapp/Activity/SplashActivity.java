package com.example.genericshopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.genericshopapp.R;

public class SplashActivity extends AppCompatActivity {

//    private ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setDisplayUseLogoEnabled(false);
        setContentView(R.layout.activity_splash);

        // TODO: Implement Backend logic for activity. This showcase
        //       is temporary.
        findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}