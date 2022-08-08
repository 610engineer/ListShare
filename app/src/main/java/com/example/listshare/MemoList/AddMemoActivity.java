package com.example.listshare.MemoList;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listshare.FirebaseClient;
import com.example.listshare.R;

public class AddMemoActivity extends AppCompatActivity {
    private  EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo);
        Button addButton = findViewById(R.id.add_memo_button);
        mEditText = findViewById(R.id.input_memo);
        FirebaseClient fc = new FirebaseClient();

        addButton.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditText.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditText.getText().toString();
                fc.AddMemo(word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
