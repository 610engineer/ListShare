package com.example.listshare.Room;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

public class DataStoreAsyncTask extends AsyncTask<Void , Void , Integer>{
    private WeakReference<Activity> weakActivity;
    private AppDatabase db;
    private TextView textView;
    private StringBuilder sb;

    public DataStoreAsyncTask(AppDatabase db , Activity activity , TextView textView){
        this.db = db;
        weakActivity = new WeakReference<>(activity);
        this.textView = textView;
    }

    @Override
    protected Integer doInBackground(Void ...params){
        int input = 1234;
        ShareListDao shareListDao = db.shareListDao();
        shareListDao.insert(new RoomEntity(input));
        sb = new StringBuilder();
        List<RoomEntity> entityList = shareListDao.getAll();
        for(RoomEntity et :entityList){
            sb.append(et.getListId()).append("\n");
        }
        return 0;
    }
}
