package com.example.genericshopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.View;
import android.widget.Button;
import android.window.SplashScreenView;

public class SplashActivity extends AppCompatActivity {

//    private ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setDisplayUseLogoEnabled(false);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}