package com.example.digpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splahscreen extends AppCompatActivity {
    private int loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splahscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home =new Intent(splahscreen.this, Login.class);
                startActivity(home);
                finish();
            }
        },loading);
    }
}