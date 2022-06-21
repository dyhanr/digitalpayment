package com.example.digpayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.text.Text;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Ordermenu extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    int minteger = 0;
    TextView jumlah1, harga1, jumlah2, harga2, jumlah3, harga3, totalharga;
    TextView  jumlah4, harga4,jumlah5, harga5;
    TextView governable, totalprice, jumlahpertama;
    Button payment;
    SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordermenu);

        //SharedPreferenceTableNumber
        TextView governable = findViewById(R.id.number_table);
        sharedPreferences = getSharedPreferences("table_details", MODE_PRIVATE);
        governable.setText(sharedPreferences.getString("table",null));

        //SharedPreferencePrice
        sharedPreferences = getSharedPreferences("price_details",MODE_PRIVATE);
        sharedPreferences.contains("price");

        //Intent to confirm payment
        Button payment = (Button) findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalprice = totalharga.getText().toString();
                String str = jumlah2.getText().toString();
                String str1 = jumlah3.getText().toString();
                String str2 = jumlah4.getText().toString();
                SharedPreferences.Editor a = sharedPreferences.edit();
                a.putString("price", finalprice);
                a.apply();
                Toast.makeText(getBaseContext(),"Confirm your Payment Now!", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(Ordermenu.this,ConfirmOrder.class);
                Intent intent = new Intent(getApplicationContext(),ConfirmOrder.class);
                intent.putExtra("message_key", str);
                intent.putExtra("americano", str1);
                intent.putExtra("uno", str2);
                startActivity(intent);
            }
        });

        //Total Price
        jumlah1 = (TextView) findViewById(R.id.integer_number);
        harga1 = (TextView) findViewById(R.id.harga1);
        jumlah2 = (TextView) findViewById(R.id.integer_number2);
        harga2 = (TextView) findViewById(R.id.harga2);
        jumlah3 = (TextView) findViewById(R.id.integer_number3);
        harga3 = (TextView) findViewById(R.id.harga3);
        jumlah4 = (TextView) findViewById(R.id.integer_number4);
        harga4 = (TextView) findViewById(R.id.harga4);
        jumlah5 = (TextView) findViewById(R.id.integer_number5);
        harga5 = (TextView) findViewById(R.id.harga5);
        totalharga = (TextView) findViewById(R.id.totalprice);


        jumlah1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        harga1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        jumlah2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        harga2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        jumlah3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        harga3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        jumlah4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        harga4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        jumlah5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        harga5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                totalharga.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        //FAB Action
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scan = new Intent(Ordermenu.this, Scanner.class);
                startActivity(scan);
            }
        });

        //BottomNavigationCode
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
    }


    private String addNumbers() {
        int number1,number2,number3,number4,number5,number6;
        int number7, number8, number9, number10;
        //Menu1
        if (jumlah1.getText().toString() != "" && jumlah1.getText().length() > 0) {
            number1 = Integer.parseInt(jumlah1.getText().toString());
        } else {
            number1 = 0;
        }
        if (harga1.getText().toString() != "" && harga1.getText().length() > 0) {
            number2 = Integer.parseInt(harga1.getText().toString());
        } else {
            number2 = 0;
        }
        //Menu2
        if (jumlah2.getText().toString() != "" && jumlah2.getText().length() > 0) {
            number3 = Integer.parseInt(jumlah2.getText().toString());
        } else {
            number3 = 0;
        }
        if (harga2.getText().toString() != "" && harga2.getText().length() > 0) {
            number4 = Integer.parseInt(harga2.getText().toString());
        } else {
            number4 = 0;
        }
        //Menu3
        if (jumlah3.getText().toString() != "" && jumlah3.getText().length() > 0) {
            number5 = Integer.parseInt(jumlah3.getText().toString());
        } else {
            number5 = 0;
        }
        if (harga3.getText().toString() != "" && harga3.getText().length() > 0) {
            number6 = Integer.parseInt(harga3.getText().toString());
        } else {
            number6 = 0;
        }
        //MENU 4
        if (jumlah4.getText().toString() != "" && jumlah4.getText().length() > 0) {
            number7 = Integer.parseInt(jumlah4.getText().toString());
        } else {
            number7 = 0;
        }
        if (harga4.getText().toString() != "" && harga4.getText().length() > 0) {
            number8 = Integer.parseInt(harga4.getText().toString());
        } else {
            number8 = 0;
        }
        //MENU5
        if (jumlah5.getText().toString() != "" && jumlah5.getText().length() > 0) {
            number9 = Integer.parseInt(jumlah5.getText().toString());
        } else {
            number9 = 0;
        }
        if (harga5.getText().toString() != "" && harga5.getText().length() > 0) {
            number10 = Integer.parseInt(harga5.getText().toString());
        } else {
            number10 = 0;
        }
        //Total Perhitungan
        return Integer.toString(
                (number1 * number2) + (number3 * number4) +
                        (number5 * number6) + (number7 * number8) +
                        (number9 * number10));
    }

    //Increment & Decrement
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);
    }
    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }
    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.integer_number);
        displayInteger.setText("" + number);
    }

    public void increaseInteger2(View view) {
        minteger = minteger + 1;
        display2(minteger);
    }
    public void decreaseInteger2(View view) {
        minteger = minteger - 1;
        display2(minteger);
    }
    private void display2(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.integer_number2);
        displayInteger.setText("" + number);
    }

    public void increaseInteger3(View view) {
        minteger = minteger + 1;
        display3(minteger);
    }
    public void decreaseInteger3(View view) {
        minteger = minteger - 1;
        display3(minteger);
    }
    private void display3(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.integer_number3);
        displayInteger.setText("" + number);
    }

    public void increaseInteger4(View view) {
        minteger = minteger + 1;
        display4(minteger);
    }
    public void decreaseInteger4(View view) {
        minteger = minteger - 1;
        display4(minteger);
    }
    private void display4(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.integer_number4);
        displayInteger.setText("" + number);
    }

    public void increaseInteger5(View view) {
        minteger = minteger + 1;
        display6(minteger);
    }
    public void decreaseInteger5(View view) {
        minteger = minteger - 1;
        display6(minteger);
    }
    private void display6(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.integer_number5);
        displayInteger.setText("" + number);
    }
}