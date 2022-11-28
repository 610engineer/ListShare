package com.example.listshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.listshare.IdList.DispListIdActivity;
import com.example.listshare.MemoList.AddMemoActivity;
import com.example.listshare.MemoList.Memo;
import com.example.listshare.MemoList.MemoAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private FirestoreRecyclerAdapter adapter;
    private FirebaseFirestore db;

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

        FirebaseClient fc = FirebaseClient.getInstance();

        //test Adapter
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        Query query = db.
                collection("test1");

        FirestoreRecyclerOptions<Memo> options = new FirestoreRecyclerOptions.Builder<Memo>()
                .setQuery(query , Memo.class)
                .build();

        adapter = new MemoAdapter(options);

        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipePosition = viewHolder.getAdapterPosition();
                MemoAdapter adapter = (MemoAdapter) recyclerView.getAdapter();
                Memo memo = adapter.getItem(swipePosition);
                String docId = memo.getDocId();
                fc.deleteMemo(docId);
            }
        };
        (new ItemTouchHelper(callback)).attachToRecyclerView(recyclerView);


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

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
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