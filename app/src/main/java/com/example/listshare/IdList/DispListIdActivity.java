package com.example.listshare.IdList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listshare.R;
import com.example.listshare.Room.EntityViewModel;
import com.example.listshare.Room.RoomEntity;
import com.example.listshare.AddItemActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DispListIdActivity extends AppCompatActivity {

    private EntityViewModel mEntityViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_disp_listid);
        FloatingActionButton fab = findViewById(R.id.fab_listId);
        RecyclerView recyclerView = findViewById(R.id.disp_listId_recycler_view);

        super.onCreate(savedInstanceState);
        //fix recyclerview layout size
        recyclerView.setHasFixedSize(true);

        //set recyclerview to layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager((layoutManager));

        //make adapter and set to recyclerview
        final ListIdAdapter adapter = new ListIdAdapter(new ListIdAdapter.IdDiff());
        recyclerView.setAdapter(adapter);

        // Get a new or existing ViewModel from the ViewModelProvider.
        mEntityViewModel = new ViewModelProvider(this).get(EntityViewModel .class);
        mEntityViewModel.getAllEntities().observe(this, entities->{
            adapter.submitList(entities);
        });

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddItemActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
    }

    public void onActivityResult(int requestCode , int resultCode , Intent data){
        super.onActivityResult(requestCode,resultCode , data);

        if(requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            RoomEntity entity = new RoomEntity(Integer.parseInt(data.getStringExtra("listId")));
            mEntityViewModel.insert(entity);

        }else{
            Toast.makeText(
                    getApplicationContext(),
                    "word not saved because it was empty",
                    Toast.LENGTH_LONG).show();
        }
    }

}
