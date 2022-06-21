package com.example.digpayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewPager_tab;
    EditText textUsername;
    TextInputEditText textPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tablayout = findViewById(R.id.tab_layout);
        viewPager_tab = findViewById(R.id.view_pager);
        tablayout.setupWithViewPager(viewPager_tab);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentAdapter.addFragment(new login_tab(), "Login");
        fragmentAdapter.addFragment(new signup_tab(), "Sign Up");
        viewPager_tab.setAdapter(fragmentAdapter);

        //Login Code
        textUsername = findViewById(R.id.email_login);
        textPassword = findViewById(R.id.pass_login);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            if (bundle.getString("some") !=null) {
                Toast.makeText(getApplicationContext(), "data:" + bundle.getString("some"),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
