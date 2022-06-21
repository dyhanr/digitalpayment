package com.example.digpayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailCafe extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cafe);

        //PopUpButton1
        Button popupButton = findViewById(R.id.btn_detailcafe1);
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupAdapter popupAdapter = new PopupAdapter();
                popupAdapter.showPopupWindow(v);
            }
        });

        Button popupButton2 = findViewById(R.id.btn_detailcafe2);
        popupButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupAdapter popupAdapter = new PopupAdapter();
                popupAdapter.showPopupWindow2(v);
            }
        });

        Button popupButton3 = findViewById(R.id.btn_detailcafe3);
        popupButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupAdapter popupAdapter = new PopupAdapter();
                popupAdapter.showPopupWindow3(v);
            }
        });

        Button popupButton4 = findViewById(R.id.btn_detailcafe4);
        popupButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupAdapter popupAdapter = new PopupAdapter();
                popupAdapter.showPopupWindow4(v);
            }
        });

        //BottomNavigationCode
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Account.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(),History.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(),Search.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
    }
}