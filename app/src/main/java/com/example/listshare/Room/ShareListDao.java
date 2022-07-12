package com.example.listshare.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShareListDao {
    //Add new ID
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomEntity entity);

    //Delete target ID
    @Delete
    void delete(RoomEntity entity);

    //Delete All ID
    @Query("DELETE FROM share_list_table")
    void deleteAll();

    @Query("SELECT * FROM share_list_table ORDER BY list_id ASC")
    LiveData<List<RoomEntity>> getASCEntity();
}
