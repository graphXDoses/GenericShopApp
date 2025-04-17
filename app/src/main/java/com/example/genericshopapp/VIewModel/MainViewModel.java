package com.example.genericshopapp.VIewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.genericshopapp.Domain.BannerModel;
import com.example.genericshopapp.Domain.CategoryModel;
import com.example.genericshopapp.Domain.ItemsModel;
import com.example.genericshopapp.Repository.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private final MainRepository repository = new MainRepository();

    public LiveData<ArrayList<CategoryModel>> loadCategory(){
        return repository.loadCategory();
    }

    public LiveData<ArrayList<BannerModel>> loadBanner(){
        return repository.loadBanner();
    }

    public LiveData<ArrayList<ItemsModel>> loadPopular(){
        return repository.loadPopular();
    }
}
