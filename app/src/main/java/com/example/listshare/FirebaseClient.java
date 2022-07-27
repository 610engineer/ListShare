package com.example.listshare;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class FirebaseClient {

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final static String TAG = "FirebaseClient";

    public void testFunc(){
        //create new user with a first and last name

        Map<String , Object> user = new HashMap<>();

        user.put("first" , "Muto");
        user.put("last" , "Masato");
        user.put("born" , 1989);

        //ad a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG , "DocumentSnapshot added with ID :" + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Log.w(TAG , "Error adding Document" , e);
                    }
                });

        // Create a new user with a first, middle, and last name
        Map<String, Object> user1 = new HashMap<>();
        user1.put("first", "Alan");
        user1.put("middle", "Mathison");
        user1.put("last", "Turing");
        user1.put("born", 2022);

     // Add a new document with a generated ID
        db.collection("users")
                .add(user1)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

}
