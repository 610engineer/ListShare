package com.example.listshare.IdList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listshare.R;

public class ListIdViewHolder extends RecyclerView.ViewHolder {
    private final TextView listIdView;

    private ListIdViewHolder(View ListIdView){
        super(ListIdView);
        listIdView = ListIdView.findViewById(R.id.textView);
    }
    public void bind(String text){listIdView.setText(text);
    }

    static ListIdViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout , parent , false);
        return new ListIdViewHolder(view);
    }
}
