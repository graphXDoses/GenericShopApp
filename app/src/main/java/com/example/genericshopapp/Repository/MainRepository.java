package com.example.genericshopapp.Repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.genericshopapp.Domain.BannerModel;
import com.example.genericshopapp.Domain.CategoryModel;
import com.example.genericshopapp.Domain.ItemsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainRepository {
    // Firebase URL needs to be explicitly passed to get an instance (for some reason).
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://genericshopapp-default-rtdb.europe-west1.firebasedatabase.app/");

    public LiveData<ArrayList<CategoryModel>> loadCategory(){
        MutableLiveData<ArrayList<CategoryModel>>  listData = new MutableLiveData<>();
        DatabaseReference ref = firebaseDatabase.getReference("Category");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<CategoryModel> list = new ArrayList<>();

                for(DataSnapshot childSnapshot :snapshot.getChildren()){
                    CategoryModel item = childSnapshot.getValue(CategoryModel.class);
                    if(item !=null)list.add(item);
                }
                listData.setValue(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return listData;
    }

    public LiveData<ArrayList<BannerModel>> loadBanner(){
        MutableLiveData<ArrayList<BannerModel>>  listData = new MutableLiveData<>();
        DatabaseReference ref = firebaseDatabase.getReference("Banner");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<BannerModel> list = new ArrayList<>();

                for(DataSnapshot childSnapshot :snapshot.getChildren()){
                    BannerModel item = childSnapshot.getValue(BannerModel.class);
                    if(item !=null)list.add(item);
                }
                listData.setValue(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return listData;
    }

    public LiveData<ArrayList<ItemsModel>> loadPopular(){
        MutableLiveData<ArrayList<ItemsModel>>  listData = new MutableLiveData<>();
        DatabaseReference ref = firebaseDatabase.getReference("Items");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<ItemsModel> list = new ArrayList<>();

                for(DataSnapshot childSnapshot :snapshot.getChildren()){
                    ItemsModel item = childSnapshot.getValue(ItemsModel.class);
                    if(item !=null)list.add(item);
                }
                listData.setValue(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return listData;
    }
}
