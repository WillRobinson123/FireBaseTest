package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.firebasetest.firebase.AccountManager;
import com.example.firebasetest.firebase.Download;


public class MainActivity extends AppCompatActivity {
    private Download download;
    private AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountManager = new AccountManager();
        accountManager.createAccount("pulsedpurpose@gmail.com","joebloggs",this);
        download = new Download();
        download.createStorageReference("pdftest.pdf");
        download.downloadTxt(MainActivity.this, "tisworking", ".pdf");
        setContentView(R.layout.activity_main);
    }
}
