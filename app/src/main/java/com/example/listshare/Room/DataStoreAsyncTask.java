package com.example.listshare.Room;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

public class DataStoreAsyncTask extends AsyncTask<Void , Void , Integer>{
    private WeakReference<Activity> weakActivity;
    private AppDatabase db;
    private String t_input;
    private StringBuilder sb;
    private TextView t_index;

    public DataStoreAsyncTask(AppDatabase db , Activity activity , String t_input , TextView t_index){
        this.db = db;
        weakActivity = new WeakReference<>(activity);
        this.t_input = t_input;
        this.t_index = t_index;
    }

    @Override
    protected Integer doInBackground(Void ...params){
        ShareListDao shareListDao = db.shareListDao();
        shareListDao.insert(new RoomEntity(Integer.parseInt(t_input)));
        sb = new StringBuilder();
        List<RoomEntity> entityList = shareListDao.getAll();
        for(RoomEntity et :entityList){
            sb.append(et.getListId()).append("\n");
        }
        return 0;
    }

    @Override
    protected void onPostExecute(Integer code){
        Activity activity = weakActivity.get();
        if(activity == null){
            return;
        }
        t_index.setText(sb.toString());
    }
}
