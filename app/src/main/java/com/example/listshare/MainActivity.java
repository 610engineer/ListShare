package com.example.listshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listshare.IdList.DispListIdActivity;
import com.example.listshare.IdList.ListIdAdapter;
import com.example.listshare.MemoList.AddMemoActivity;
import com.example.listshare.MemoList.Memo;
import com.example.listshare.MemoList.MemoAdapter;
import com.example.listshare.MemoList.MemoViewHolder;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        FloatingActionButton fab = findViewById(R.id.fab);
        Button dispListIdBt = findViewById(R.id.disp_List_id);

        //button for test
        Button bt1 = findViewById(R.id.button1);
        Button bt2 = findViewById(R.id.button2);
        Button bt3 = findViewById(R.id.button3);

        FirebaseClient fc = new FirebaseClient();

        Query query = FirebaseFirestore.getInstance()
                .collection("users")
                .orderBy("timestamp");

        //test Adapter

        FirestoreRecyclerOptions<Memo> options = new FirestoreRecyclerOptions.Builder<Memo>()
                .setQuery(query , Memo.class)
                .build();

        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<Memo , MemoViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NotNull MemoViewHolder holder, int position, Memo model) {
                holder.setMemoView(model.getMemo());
            }

            @NonNull
            @NotNull
            @Override
            public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup group, int viewType) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.row_layout , group , false);
                return new MemoViewHolder(view);
            }

        };




        //fix recyclerview layout size
        recyclerView.setHasFixedSize(true);

        //set recyclerview to layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager((layoutManager));

        //make adapter and set to recyclerview
        /*FirestoreRecyclerOptions<Memo> options = new FirestoreRecyclerOptions.Builder<Memo>()
                .setQuery(query,Memo.class)
                .build();
        List<String> dataset = new ArrayList<>();
         */
        //final MemoAdapter adapter = new MemoAdapter(options);
        recyclerView.setAdapter(adapter);




        dispListIdBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , DispListIdActivity.class);
                startActivity(intent);
            }
        });


        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddMemoActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });

        //for test



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.testFunc();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.testRead();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.testDelete();
            }
        });

    }







    private String[] createRowData(){
        String[] dataSet = new String[10];
        int i = 0;
        while(i < 10){
            dataSet[i] = "hogehoge";
            i++;
        }
        return dataSet;
    }
}