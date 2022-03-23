package com.example.listshare.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShareListDao {
    @Query("SELECT * FROM share_list_DB")
    List<RoomEntity> getAll();

    @Insert
    void insert(RoomEntity entity);

    @Delete
    void delete(RoomEntity entity);
}
