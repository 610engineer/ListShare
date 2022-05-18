package com.example.listshare;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.listshare.Room.RoomEntity;
import com.google.protobuf.Internal;

import java.util.List;

public class ListIdAdapter extends ListAdapter<RoomEntity , ListIdViewHolder> {
    public ListIdAdapter(@NonNull DiffUtil.ItemCallback<RoomEntity> diffCallBack){
        super(diffCallBack);
    }

    @Override
    public ListIdViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        return ListIdViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ListIdViewHolder holder , int position){
        RoomEntity current = getItem(position);
        holder.bind(current.getListId());
    }
}
