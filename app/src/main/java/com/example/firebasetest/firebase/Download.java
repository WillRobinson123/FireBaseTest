package com.example.firebasetest.firebase;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

import com.example.firebasetest.MainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Download {

    private StorageReference assetStorage;
    private StorageReference folder;

    public void createStorageReference(String filePath){
        assetStorage = FirebaseStorage.getInstance().getReference();
        folder = assetStorage.child(filePath);
    }

    public void downloadTxt(final Context mainActivity, final String fileName, final String fileExt) {
        folder.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFileManager(mainActivity, fileName, fileExt, DIRECTORY_DOWNLOADS,url);
            }
        });

    }

    private void downloadFileManager(Context context, String fileName, String fileExtension, String destinationDirectory, String url){
        DownloadManager downloadManager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }
}
