package com.example.firebasetest.firebase;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class AccountManager {
    private FirebaseAuth mAuth;

    public AccountManager(){
        mAuth = FirebaseAuth.getInstance();
    }

    public void createAccount(String email, String password, Activity mainActivity){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(mainActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                });
    }



}
