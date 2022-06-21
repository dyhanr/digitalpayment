package com.example.digpayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class Account extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    BottomNavigationView bottomNavigationView;
    FirebaseAuth objectFirebaseAuth;
    private TextView emailpertama,emailkedua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        objectFirebaseAuth=FirebaseAuth.getInstance();
        emailpertama= findViewById(R.id.emaildetail);
        emailkedua = findViewById(R.id.emaildetail2);
        if(objectFirebaseAuth!=null)
        {
            String currentUser = objectFirebaseAuth.getCurrentUser().getEmail();
            emailpertama.setText(currentUser);
            emailkedua.setText(currentUser);
        }

        //BottomNavigationCode
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
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

        //sharedPrefrences
//        TextView result = findViewById(R.id.detailusername2);
//        TextView resultakun = findViewById(R.id.fullname);
//        sharedPreferences =getSharedPreferences("user_details",MODE_PRIVATE);
//        result.setText(sharedPreferences.getString("username",null));
//        resultakun.setText(sharedPreferences.getString("username",null));



        RelativeLayout backhome = (RelativeLayout) findViewById(R.id.backbutton2);
        backhome.setOnClickListener(view -> {
            Intent intent = new Intent (Account.this, MainActivity.class);
            startActivity(intent);
        });

//        passInput2 = findViewById(R.id.pass_profile);
//        ShowPass2 = findViewById(R.id.checkpass);
//        ShowPass2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(ShowPass2.isChecked()){
//                    passInput2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                } else {
//                    passInput2.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                }
//            }
//        });

        //FAB Action
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scan = new Intent(Account.this, Scanner.class);
                startActivity(scan);
            }
        });
    }
}