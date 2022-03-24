package com.example.listshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.listshare.Room.AppDatabase;
import com.example.listshare.Room.AppDatabaseSingleton;
import com.example.listshare.Room.DataStoreAsyncTask;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        FloatingActionButton fab = findViewById(R.id.add_fab);

        //for test
        Button t_button = findViewById(R.id.t_button);
        EditText t_input = findViewById(R.id.t_input);
        TextView t_index = findViewById(R.id.t_index);
        Activity activity = this;
        AppDatabase db = AppDatabaseSingleton.getInstance(getApplicationContext());
        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = t_input.getText().toString();
                t_index.setText(text);
                new DataStoreAsyncTask(db , activity , t_index);

            }
        });

        //fix recyclerview layout size
        recyclerView.setHasFixedSize(true);

        //set recyclerview to layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager((layoutManager));

        //make adapter and set to recyclerview
        RecyclerView.Adapter mainAdapter = new MainAdapter(createRowData());
        recyclerView.setAdapter(mainAdapter);

       fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
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