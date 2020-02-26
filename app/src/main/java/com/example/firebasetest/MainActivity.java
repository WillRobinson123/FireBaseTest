package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.firebasetest.firebase.AccountManager;
import com.example.firebasetest.firebase.Download;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private Download download;
    private AccountManager accountManager;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
}
