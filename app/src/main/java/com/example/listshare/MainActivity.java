package com.example.listshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.listshare.IdList.DispListIdActivity;
import com.example.listshare.IdList.ListIdAdapter;
import com.example.listshare.MemoList.AddMemoActivity;
import com.example.listshare.MemoList.MemoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        //fix recyclerview layout size
        recyclerView.setHasFixedSize(true);

        //set recyclerview to layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager((layoutManager));

        //make adapter and set to recyclerview
        List<String> dataset = new ArrayList<>();
        dataset = fc.GetMemoList();
        final MemoAdapter adapter = new MemoAdapter(dataset);
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