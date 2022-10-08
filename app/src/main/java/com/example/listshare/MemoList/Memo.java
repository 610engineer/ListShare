package com.example.listshare.MemoList;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Memo {
    private String mMemo;
    private String mDocId;
    //private Date mTimeStamp;
    private int mQty;

    public Memo(){

    }

    public Memo(String memo , String docId ,int qty){
        mMemo = memo;
        mDocId = docId;
        mQty = qty;
    }

    public String getMemo(){
        return mMemo;
    }

    public String getDocId(){
        return mDocId;
    }

    public int getQty(){
        return mQty;
    }

    public void setMemo(String memo){
        mMemo = memo;
    }

    public void setDocId(String id){
        mDocId = id;
    }

    public void setQty(int qty){
        mQty = qty;
    }

}
