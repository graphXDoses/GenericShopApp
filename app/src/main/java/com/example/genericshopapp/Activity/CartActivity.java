package com.example.genericshopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.genericshopapp.Adapter.CartAdapter;
import com.example.genericshopapp.Helper.ChangeNumberItemsListener;
import com.example.genericshopapp.Helper.ManagmentCart;
import com.example.genericshopapp.R;
import com.example.genericshopapp.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;
    private double tax;
    private ManagmentCart managementCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managementCart = new ManagmentCart(this);
        
        calculatorCart();
        setVariable();
        initCartList();
        
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> {

        });
    }

    private void initCartList() {

        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.cartView.setAdapter(new CartAdapter());

        if(managementCart.getListCart().isEmpty()){

            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollView2.setVisibility(View.GONE);
            binding.backBtn.setVisibility(View.VISIBLE);

        }else{

            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollView2.setVisibility(View.VISIBLE);

        }

        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.cartView.setAdapter(new CartAdapter(managementCart.getListCart(), this, this::calculatorCart));


        
    }

    private void calculatorCart() {

        double percentTax = 0.02;
        double delivery = 10;
        tax = Math.round((managementCart.getTotalFee() * percentTax*100.0))/100.0;

        double total = Math.round(managementCart.getTotalFee() + tax + delivery *100.0)/ 100.0;
        double itemTotal = Math.round((managementCart.getTotalFee()*100.0))/100.0;

        binding.subtotalTxt.setText("$" + itemTotal);
        binding.taxTxt.setText("$" + tax);
        binding.deliveryTxt.setText("$" + delivery);
        binding.totalTxt.setText("$" + total);
    }

}