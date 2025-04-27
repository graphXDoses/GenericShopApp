package com.example.genericshopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        setContentView(R.layout.activity_cart);

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

        if(managementCart.getListCart().isEmpty()){

            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollView2.setVisibility(View.GONE);

        }else{

            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollView2.setVisibility(View.VISIBLE);

        }
        
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