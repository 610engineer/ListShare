package com.example.listshare.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "share_list_table")
public class RoomEntity {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "list_id")
    private int listId;

    public RoomEntity(int listId){
        this.listId = listId;
    }

    public void setUid(int id){
        this.uid = id;
    }

    public void setListId(int listId){
        this.listId = listId;
    }

    public int getUid(){
        return uid;
    }

    public String getListId(){
        return Integer.toString(listId);
    }
}