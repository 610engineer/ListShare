package com.example.listshare;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "share_list_id")
public class roomEntity {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "list_id")
    private int listId;

    public void setUid(int id){
        this.uid = id;
    }

    public void setListId(int listId){
        this.listId = listId;
    }

    public int getUid(){
        return uid;
    }

    public int getListId(){
        return listId;
    }
}