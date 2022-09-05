package com.example.listshare.MemoList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listshare.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MemoAdapter extends FirestoreRecyclerAdapter<Memo , MemoAdapter.MemoViewHolder> {
    private List<String> localDataSet;

    public MemoAdapter(
            @NonNull FirestoreRecyclerOptions<Memo> options
    ){
        super(options);
    }

    class MemoViewHolder extends RecyclerView.ViewHolder{
        TextView memo;
        public MemoViewHolder(@NonNull View view){
            super(view);
            memo = view.findViewById(R.id.textView);
        }
    }

    @Override
    protected void onBindViewHolder(@NonNull MemoViewHolder holder, int position , @NonNull Memo model){
        holder.memo.setText(model.getMemo());
    }

    public MemoViewHolder onCreateViewHolder(ViewGroup viewGroup , int viewType){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_layout , viewGroup, false);
        return  new MemoViewHolder(view);
    }
}
