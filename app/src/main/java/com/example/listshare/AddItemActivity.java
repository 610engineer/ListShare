package com.example.listshare;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listshare.R;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class AddItemActivity extends AppCompatActivity {
    private  EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Button addButton = findViewById(R.id.add_button);
        mEditText = findViewById(R.id.input_text);

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
