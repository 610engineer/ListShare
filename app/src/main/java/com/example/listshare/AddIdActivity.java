package com.example.listshare;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddIdActivity extends AppCompatActivity {
    private  EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_id);
        Button addButton = findViewById(R.id.add_item_button);
        mEditText = findViewById(R.id.input_id);

        addButton.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditText.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditText.getText().toString();
                replyIntent.putExtra("listId", word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
