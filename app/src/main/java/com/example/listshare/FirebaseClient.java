package com.example.listshare;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseClient {

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final static String TAG = "FirebaseClient";
    public List<String> GetMemoList(){
        List<String> dataset = new ArrayList<>();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Map<String, Object> values = document.getData();
                                dataset.add(values.get("first").toString());
                            }
                        }else{
                            Log.w(TAG, "Error getting Document" , task.getException());
                        }
                    }
                });
        return dataset;
    }

    public void testFunc(){
        //create new user with a first and last name

        Map<String , Object> user = new HashMap<>();

        user.put("first" , "Muto");
        user.put("last" , "honami");
        user.put("born" , 2222);

        //ad a new document with a generated ID
        db.collection("users").document("test1")
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG , "documentSnapshot successfully written!");
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
        db.collection("users").document("test2")
                .set(user1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG , "documentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Log.w(TAG , "Error adding Document" , e);
                    }
                });
    }

    public void testRead(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Map<String, Object> values = document.getData();
                                Log.d(TAG,document.getId() + "->" + values.get("born"));
                            }
                        }else{
                            Log.w(TAG, "Error getting Document" , task.getException());
                        }
                    }
                });
    }

    public void testDelete(){
        db.collection("users").document("test1")
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Log.w(TAG , "Error Deleting document" , e);
            }
        });
    }

}
