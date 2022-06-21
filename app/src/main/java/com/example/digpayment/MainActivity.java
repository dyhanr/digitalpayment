package com.example.digpayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.window.SplashScreen;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    SharedPreferences sharedPreferences;
    FirebaseAuth objectFirebaseAuth;
    TextView usernameprofile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //sharedPrefrences
//        TextView result = findViewById(R.id.usernameprofile);
//        sharedPreferences =getSharedPreferences("user_details",MODE_PRIVATE);
//        result.setText(sharedPreferences.getString("username",null));

        objectFirebaseAuth=FirebaseAuth.getInstance();
        usernameprofile= findViewById(R.id.usernameprofile);
        if(objectFirebaseAuth!=null)
        {
            String currentUser = objectFirebaseAuth.getCurrentUser().getEmail();
            usernameprofile.setText(currentUser);
        }

        //Banner Logic Code
        ViewPager Banner = findViewById(R.id.view_pager);
        ImageAdapter adapterView = new ImageAdapter(this);
        Banner.setAdapter(adapterView);

        //IntentMenu
        Button btnmenu = findViewById(R.id.cafeday);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cafeday = new Intent(MainActivity.this,Search.class);
                startActivity(cafeday);
            }
        });
        Button btnmenu2 = findViewById(R.id.cafeplace);
        btnmenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cafeplace = new Intent (MainActivity.this, Ordermenu.class);
                startActivity(cafeplace);
            }
        });
        Button btnmenu3 = findViewById(R.id.caferow);
        btnmenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent caferow = new Intent(MainActivity.this, Ordermenu.class);
                startActivity(caferow);
            }
        });

        Button btnmenu4 = findViewById(R.id.cafetree);
        btnmenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cafetree = new Intent(MainActivity.this, TestingPage.class);
                startActivity(cafetree);
            }
        });

        //Intent Image Button
        ImageButton btnlogut = findViewById(R.id.btn_logout);
                btnlogut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (objectFirebaseAuth!=null)
                        {
                            objectFirebaseAuth.signOut();
                            startActivity(new Intent(MainActivity.this,Login.class));
                            finish();
                        }
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

        //FAB SCAN CODE
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scan = new Intent(MainActivity.this, Scanner.class);
                startActivity(scan);
            }
        });
    }

    public void click(View view){
        Intent intent = null;
        switch(view.getId()){
            case R.id.btn_seecafe:
                intent = new Intent(this, DetailCafe.class);
                break;
            case R.id.btn_seekopi:
                intent = new Intent(this, Ordermenu.class);
                break;
        }
        startActivity(intent);
    }
    
}