package com.example.listshare.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "share_list_table")
public class RoomEntity {
    @PrimaryKey
    //public int uid;

    //ShareList id
    @NonNull
    @ColumnInfo(name = "list_id")
    public int listId;

    public RoomEntity(@NonNull int listId){
        this.listId = listId;
    }

    /*
    public int getUid(){
        return uid;
    }
    */

    public String getListId(){
        return Integer.toString(listId);
    }

}