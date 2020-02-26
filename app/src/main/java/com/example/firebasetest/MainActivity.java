package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.firebasetest.firebase.AccountManager;
import com.example.firebasetest.firebase.Download;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private Download download;
    private AccountManager accountManager;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private String text = "Done!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        setContentView(R.layout.activity_main);
    }
}
