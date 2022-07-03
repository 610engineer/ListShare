package com.example.listshare.Room;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.listshare.R;

import java.util.List;

public class EntiryViewModel extends AndroidViewModel {
    private ShareListRepository mRepository;
    private final LiveData<List<RoomEntity>> mAllEntities;

    public EntiryViewModel(Application application){
        super(application);
        mRepository = new ShareListRepository(application);
        mAllEntities = mRepository.getAllEntities();
    }

    LiveData<List<RoomEntity>> getmAllEntities() {return mAllEntities;}
    public void insert(RoomEntity entity) {mRepository.insert(entity);}
}
