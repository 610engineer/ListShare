package com.example.listshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.listshare.Room.EntityViewModel;
import com.example.listshare.Room.RoomEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private EntityViewModel mEntityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        FloatingActionButton fab = findViewById(R.id.fab);
        //fix recyclerview layout size
        recyclerView.setHasFixedSize(true);

        //set recyclerview to layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager((layoutManager));

        //make adapter and set to recyclerview
        final ListIdAdapter adapter = new ListIdAdapter(new ListIdAdapter.WordDiff());
        recyclerView.setAdapter(adapter);

        // Get a new or existing ViewModel from the ViewModelProvider.
        mEntityViewModel = new ViewModelProvider(this).get(EntityViewModel.class);
        mEntityViewModel.getAllEntities().observe(this, entities->{
            adapter.submitList(entities);
        });

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });

        //for test
        FirebaseClient fc = new FirebaseClient();
        fc.testFunc();

    }

    public void onActivityResult(int requestCode , int resultCode , Intent data){
        super.onActivityResult(requestCode,resultCode , data);

        if(requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            RoomEntity entity = new RoomEntity(Integer.parseInt(data.getStringExtra("listId")));
            mEntityViewModel.insert(entity);

        }else{
            Toast.makeText(
                    getApplicationContext(),
                    "word not saved becasue it was empty",
                    Toast.LENGTH_LONG).show();
        }
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