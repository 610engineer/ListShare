package com.example.listshare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListIdViewHolder extends RecyclerView.ViewHolder {
    private final TextView listIdView;

    private ListIdViewHolder(View ListIdView){
        super(ListIdView);
        listIdView = ListIdView.findViewById(R.id.title_text_view);
    }
    public void bind(String text){
        listIdView.setText(text);
    }

    static ListIdViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout , parent , false);
        return new ListIdViewHolder(view);
    }
}
