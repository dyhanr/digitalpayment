package com.example.digpayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class ConfirmOrder extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    SharedPreferences sharedPreferences;
    TextView addorder,finalprice,pertama,reciver_msg, americano_details,uno_details;
    RadioButton midtrans,alipay;
    Button payment;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        //SharedPreferenceTableNumber
        TextView governable = findViewById(R.id.number_table);
        sharedPreferences = getSharedPreferences("table_details", MODE_PRIVATE);
        governable.setText(sharedPreferences.getString("table",null));

        //SharedPreferencePrice
        TextView finalprice = findViewById(R.id.confirm_totalprice);
        sharedPreferences = getSharedPreferences("price_details",MODE_PRIVATE);
        finalprice.setText(sharedPreferences.getString("price",null));

        reciver_msg = (TextView) findViewById(R.id.integer_number2);
        String str = getIntent().getStringExtra("message_key");
        reciver_msg.setText(str);

        americano_details = (TextView) findViewById(R.id.integer_number3);
        String str1 = getIntent().getStringExtra("americano");
        americano_details.setText(str1);

        uno_details = (TextView) findViewById(R.id.integer_number);
        String str2 = getIntent().getStringExtra("uno");
        uno_details.setText(str2);

        //Radiobutton
        midtrans = findViewById(R.id.midtrans);
        alipay = findViewById(R.id.alipay);
        TextView result = findViewById(R.id.result_radiobutton);

        midtrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!midtrans.isSelected()){
                    midtrans.setChecked(true);
                    alipay.setChecked(false);
                    result.setText("Midtrans");
                    result.setTextColor(Color.parseColor("#2196F3"));
                } else {
                    result.setText("Midtrans");
                    result.setTextColor(Color.parseColor("#2196F3"));
                }
            }
        });
        alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!alipay.isSelected()){
                    alipay.setChecked(true);
                    midtrans.setChecked(false);
                    result.setText("Alipay");
                    result.setTextColor(Color.parseColor("#2196F3"));
                } else{
                    result.setText("Alipay");
                    result.setTextColor(Color.parseColor("#2196F3"));
                }
            }
        });

        //AddtoOrder
        addorder = (TextView) findViewById(R.id.addorder);
        addorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmOrder.this, Ordermenu.class);
                startActivity(i);
            }
        });

        //Button Payment
        payment = findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result.getText().toString().equals("Midtrans")){
                    String url = "https://app.sandbox.midtrans.com/payment-links/1654004831330";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if (result.getText().toString().equals("Alipay")) {
                    Toast.makeText(getApplicationContext(),"Alipay Under Construction",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Choose your payment Method",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //BottomNavigationCode
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.history);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), History.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        //FAB Action
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scan = new Intent(ConfirmOrder.this, Scanner.class);
                startActivity(scan);
            }
        });
    }
}