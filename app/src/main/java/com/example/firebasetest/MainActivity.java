package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.firebasetest.firebase.AccountManager;
import com.example.firebasetest.firebase.Download;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private Download download;
    private AccountManager accountManager;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseReference myRef = database.getReference("picture/pic_1");
        //myRef.setValue("Please work");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text = dataSnapshot.getValue(String.class);
                System.out.println(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("The Read Failed");
            }
        });

        setContentView(R.layout.activity_main);
    }
}
