package com.example.listshare.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.listshare.Room.RoomEntity;
import com.example.listshare.Room.ShareListDao;

@Database(entities = {RoomEntity.class} , version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShareListDao shareListDao();
}
