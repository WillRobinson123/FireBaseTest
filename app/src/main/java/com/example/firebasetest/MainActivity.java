package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private StorageReference assetStorage;
    private StorageReference HelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createStorageReference();
        downloadTxt();
        setContentView(R.layout.activity_main);
    }

    private void createStorageReference(){
        assetStorage = FirebaseStorage.getInstance().getReference();
        HelloWorld = assetStorage.child("HelloWorld.txt");
    }

    private void downloadTxt() {
        try {
            File myTxt = File.createTempFile("HelloWorld", "txt");

            HelloWorld.getFile(myTxt)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            // Successfully downloaded data to local file
                            // ...
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle failed download
                    // ...
                }
            });
        }
        catch(Exception e){
            System.out.println("yeet");
        }

    }
}
