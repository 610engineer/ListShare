package com.example.listshare.MemoList;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Memo {
    private String mMemo;
    //private Date mTimeStamp;
    private int mQty;

    public Memo(){

    }

    public Memo(String memo , int qty){
        mMemo = memo;
        mQty = qty;
    }

    public String getMemo(){
        return mMemo;
    }

    public int getQty(){
        return mQty;
    }

    public void setMemo(String memo){
        mMemo = memo;
    }

    public void setQty(int qty){
        mQty = qty;
    }

}
