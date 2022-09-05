package com.example.listshare.MemoList;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listshare.R;

public class MemoViewHolder extends RecyclerView.ViewHolder {
    private final TextView memoView;

    public MemoViewHolder(View view){
        super(view);
        memoView = view.findViewById(R.id.textView);
    }

    public void setMemoView(String memo) {
        memoView.setText(memo);
    }

}
