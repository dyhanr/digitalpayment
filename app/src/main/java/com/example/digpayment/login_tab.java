package com.example.digpayment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class login_tab extends Fragment {
    Intent intent;
    EditText username, password, email;
    private View objectLoginFragment;
    private FirebaseAuth objectFirebaseAuth;
    private EditText login_email, login_password;
    private ProgressBar objectProgressBar;
    Button btn_login;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        objectLoginFragment = inflater.inflate(R.layout.fragment_login_tab, container, false);
        initializeVariable();

//        //sharedPreferenceUsername
//        username = objectLoginFragment.findViewById(R.id.username_login);
//        SharedPreferences sharedPref = requireActivity().getSharedPreferences("user_details", Context.MODE_PRIVATE);
//        sharedPref.contains("username");

        return objectLoginFragment;
    }

    private void initializeVariable()
    {
        try
        {
            objectFirebaseAuth=FirebaseAuth.getInstance();
            email=objectLoginFragment.findViewById(R.id.email_login);
            password=objectLoginFragment.findViewById(R.id.pass_login);
            btn_login=objectLoginFragment.findViewById(R.id.btn_login);
            objectProgressBar=objectLoginFragment.findViewById(R.id.progressbar_login);
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginUser();
                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void loginUser()
    {
        try
        {
            if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty())
            {
                if(objectFirebaseAuth!=null)
                {
                    objectProgressBar.setVisibility(View.VISIBLE);
                    btn_login.setEnabled(false);

                    objectFirebaseAuth.signInWithEmailAndPassword(email.getText().toString(),
                            password.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(getActivity().getApplicationContext(),MainActivity.class));
                                    objectProgressBar.setVisibility(View.INVISIBLE);
                                    btn_login.setEnabled(true);
                                    getActivity().finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    objectProgressBar.setVisibility(View.INVISIBLE);
                                    btn_login.setEnabled(true);
                                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
            else
            {
                Toast.makeText(getContext(), "Please Fill Both Fields", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {

        }
    }
}
