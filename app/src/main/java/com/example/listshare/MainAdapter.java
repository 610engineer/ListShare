package com.example.listshare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private String[] rowDataList;

    MainAdapter(String[] rowDataList){
        this.rowDataList = rowDataList;
    }

    //single data
    static class MainViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        MainViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.textView);
        }
    }

    //initial method
    //this method makes viewholder and return it to Recyclerview
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent , false);
                return new MainViewHolder(view);
    }

    //Binding ViewHolder and  RecyclerView
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder , int position){
        String rowData = this.rowDataList[position];
        holder.title.setText(rowData);
    }

    //number of data
    public int getItemCount(){
        return rowDataList.length;
    }

}
