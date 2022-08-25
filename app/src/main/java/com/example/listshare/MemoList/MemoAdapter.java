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

    public MemoAdapter(FirestoreRecyclerOptions<Memo> option){
        super(option);
    }

    public MemoViewHolder onCreateViewHolder(ViewGroup viewGroup , int viewType){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_layout , viewGroup, false);
        return  new MemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MemoViewHolder holder, int position , Memo model) {
        holder.setMemoView(model.getMemo());
    }

    public int getItemCount(){
        return localDataSet.size();
    }
}
