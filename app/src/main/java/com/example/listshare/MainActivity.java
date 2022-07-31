package com.example.listshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.listshare.IdList.DispListIdActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        dispListIdBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , DispListIdActivity.class);
                startActivity(intent);
            }
        });


        fab.setOnClickListener(view -> {
            //Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
        });

        //for test
        FirebaseClient fc = new FirebaseClient();


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