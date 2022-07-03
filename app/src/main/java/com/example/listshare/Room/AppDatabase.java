package com.example.listshare.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.listshare.Room.RoomEntity;
import com.example.listshare.Room.ShareListDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RoomEntity.class} , version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShareListDao shareListDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    //RoomDBが存在したら返し、存在しなければ作成する
    static AppDatabase getDatabase(final Context context){
        if(INSTANCE != null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context , AppDatabase.class , "shareListDB")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
