package com.example.listshare.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShareListRepository {
    private ShareListDao mShareListDao;
    private LiveData<List<RoomEntity>> mAllEntity;

    ShareListRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        mShareListDao = db.shareListDao();
        mAllEntity = mShareListDao.getASCEntity();
    }

    LiveData<List<RoomEntity>> getAllEntities(){
        return mAllEntity;
    }

    void insert(RoomEntity entity){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mShareListDao.insert(entity);
        });
    }
}
