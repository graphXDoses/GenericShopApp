package com.example.genericshopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.genericshopapp.R;

public class CartActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // TODO: Implement Backend logic for activity. This showcase
        //       is temporary.
        
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
                finish();
            }
        });
    }

}