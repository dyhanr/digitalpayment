package com.example.digpayment;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup_tab extends Fragment {
    Intent intent;
    private EditText inputEmail, inputPassword;
    private  FirebaseAuth objectFirebaseAuth;
    private Button btn_signup;
    View objectSignUpFragments;
    private ProgressBar objectProgressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        objectSignUpFragments = inflater.inflate(R.layout.fragment_signup_tab, container, false);
        attachXML();
        return objectSignUpFragments;
    }

    private void attachXML()
    {
        try
        {
            inputEmail=objectSignUpFragments.findViewById(R.id.email_signup);
            inputPassword=objectSignUpFragments.findViewById(R.id.password_signup);
            objectFirebaseAuth=FirebaseAuth.getInstance();
            btn_signup=objectSignUpFragments.findViewById(R.id.btn_signup);
            objectProgressBar=objectSignUpFragments.findViewById(R.id.progressbar_signup);
//            username=objectSignUpFragments.findViewById(R.id.username_signup);
            btn_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createUser();
                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void createUser(){
        try
        {
            if(!inputEmail.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty())
            {
                objectProgressBar.setVisibility(View.VISIBLE);
                btn_signup.setEnabled(false);
                objectFirebaseAuth.createUserWithEmailAndPassword(inputEmail.getText().toString(),
                        inputPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(getContext(), "Registrasion Succesfull", Toast.LENGTH_SHORT).show();
                                objectProgressBar.setVisibility(View.INVISIBLE);
                                btn_signup.setEnabled(true);
                                inputEmail.setText("");
                                inputPassword.setText("");
                                Intent a = new Intent(getActivity(),Login.class);
                                startActivity(a);

                                if(objectFirebaseAuth.getCurrentUser() !=null)
                                {
                                    objectFirebaseAuth.signOut();
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                objectProgressBar.setVisibility(View.INVISIBLE);
                                btn_signup.setEnabled(true);
                                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            else
            {
                Toast.makeText(getContext(), "Please fill the field first ", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}




