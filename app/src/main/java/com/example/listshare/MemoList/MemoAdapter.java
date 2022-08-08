package com.example.listshare.MemoList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listshare.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MemoViewHolder> {
    private List<String> localDataSet;

    public class MemoViewHolder extends RecyclerView.ViewHolder {
        private final TextView memoView;

        public MemoViewHolder(View view){
            super(view);
            memoView = view.findViewById(R.id.textView);
        }

        public TextView getMemoView() {
            return memoView;
        }
    }

    public MemoAdapter(List<String> dataSet){
        localDataSet = dataSet;
    }

    public MemoViewHolder onCreateViewHolder(ViewGroup viewGroup , int viewType){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_layout , viewGroup, false);
        return  new MemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MemoViewHolder holder, int position) {
        holder.getMemoView().setText(localDataSet.get(position));
    }

    public int getItemCount(){
        return localDataSet.size();
    }
}
