package com.example.genericshopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.genericshopapp.Adapter.CategoryAdapter;
import com.example.genericshopapp.R;
import com.example.genericshopapp.VIewModel.MainViewModel;
import com.example.genericshopapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new MainViewModel();
        initCategory();

        // TODO: Implement Backend logic for activity. This showcase
        //       is temporary.
        ((ImageView) findViewById(R.id.imageView5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
                finish();
            }
        });
    }

    private void initCategory() {
        // Just to initialize the layout manager & adapter.
        binding.categoryView.setLayoutManager(new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        binding.categoryView.setAdapter(new CategoryAdapter());

        binding.progressBarCategory.setVisibility(View.VISIBLE);
        viewModel.loadCategory().observeForever(categoryModels -> {
                binding.categoryView.setLayoutManager(new LinearLayoutManager(
                        MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                binding.categoryView.setAdapter(new CategoryAdapter(categoryModels));
                binding.categoryView.setNestedScrollingEnabled(true);
                binding.progressBarCategory.setVisibility(View.GONE);

        });

    }
}