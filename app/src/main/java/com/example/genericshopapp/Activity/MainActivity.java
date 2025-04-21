package com.example.genericshopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.genericshopapp.Adapter.CategoryAdapter;
import com.example.genericshopapp.Adapter.PopularAdapter;
import com.example.genericshopapp.Adapter.SliderAdapter;
import com.example.genericshopapp.Domain.BannerModel;
import com.example.genericshopapp.R;
import com.example.genericshopapp.VIewModel.MainViewModel;
import com.example.genericshopapp.databinding.ActivityMainBinding;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

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
        initSlider();
        initPopular();
        bottomNavigation();


    }
    private void bottomNavigation() {

        binding.bottomNavigation.setItemSelected(R.id.home,true);
        binding.bottomNavigation.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

            }
        });
        binding.cartBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void initPopular() {
        binding.progressBarPopular.setVisibility(View.VISIBLE);
        binding.popularView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        binding.popularView.setAdapter(new PopularAdapter());
        viewModel.loadPopular().observeForever(itemsModels -> {
            if (!itemsModels.isEmpty()){
                binding.popularView.setLayoutManager(
                        new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                binding.popularView.setAdapter(new PopularAdapter(itemsModels));
                binding.popularView.setNestedScrollingEnabled(true);
            }
            binding.progressBarPopular.setVisibility(View.GONE);
        });
        viewModel.loadPopular();
    }

    private void initializeBannerLayout()
    {
        binding.viewPagerSlider.setClipToPadding(false);
        binding.viewPagerSlider.setClipChildren(false);
        binding.viewPagerSlider.setOffscreenPageLimit(3);
        binding.viewPagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));

        binding.viewPagerSlider.setPageTransformer(compositePageTransformer);
    }


    private void initSlider(){
        binding.progressBarSlider.setVisibility(View.VISIBLE);
        binding.viewPagerSlider.setAdapter(new SliderAdapter());
        initializeBannerLayout();

        viewModel.loadBanner().observeForever(bannerModels -> {
            if(bannerModels!=null && !bannerModels.isEmpty()){
                banners(bannerModels);
                binding.progressBarSlider.setVisibility(View.GONE);
            }
        });

        viewModel.loadBanner();
    }

    private void banners(ArrayList<BannerModel> bannerModels){
        binding.viewPagerSlider.setAdapter(new SliderAdapter(bannerModels, binding.viewPagerSlider));
        initializeBannerLayout();
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