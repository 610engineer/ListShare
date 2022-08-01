package com.example.listshare.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.listshare.Room.RoomEntity;
import com.example.listshare.Room.ShareListDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RoomEntity.class} , version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    abstract ShareListDao shareListDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //if DB does not exist , create new DB
    static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context , AppDatabase.class , "shareList_DB")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);

            databaseWriteExecutor.execute(()->{
                //Populate the database in the background
                ShareListDao dao = INSTANCE.shareListDao();
                dao.deleteAll();

                RoomEntity entity = new RoomEntity(123);
                dao.insert(entity);
                entity = new RoomEntity(345);
                dao.insert(entity);
            });

        }
    };
}
