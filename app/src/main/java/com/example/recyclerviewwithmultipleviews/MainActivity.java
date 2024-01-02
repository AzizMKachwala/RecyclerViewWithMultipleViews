package com.example.recyclerviewwithmultipleviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    List<ChatDataModel> chatDataModelsList;
    RecyclerView ListChat;
    ChatAdapter chatAdapter;
    EditText editTextMessage;
    Button buttonSend,buttonReceive,buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListChat = findViewById(R.id.chatRecyclerView);
        editTextMessage = findViewById(R.id.etvMessage);
        buttonSend = findViewById(R.id.btnSend);
        buttonReceive = findViewById(R.id.btnReceive);
        buttonClear = findViewById(R.id.btnClear);

        chatDataModelsList = new ArrayList<>();
        chatDataModelsList.add(new ChatDataModel("Hello", getCurrentTime(), "0"));
        chatDataModelsList.add(new ChatDataModel("Hi", getCurrentTime(), "1"));
        chatDataModelsList.add(new ChatDataModel("How Are You?", getCurrentTime(), "1"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ListChat.setLayoutManager(linearLayoutManager);

        chatAdapter = new ChatAdapter(chatDataModelsList, this);
        ListChat.setAdapter(chatAdapter);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                String message = editTextMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    chatDataModelsList.add(new ChatDataModel(message, getCurrentTime(), "0"));
                    chatAdapter.notifyDataSetChanged();
                    editTextMessage.setText("");

                    ListChat.scrollToPosition(chatDataModelsList.size() - 1);
                }
            }
        });

        buttonReceive.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                String message = editTextMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    chatDataModelsList.add(new ChatDataModel(message, getCurrentTime(), "1"));
                    chatAdapter.notifyDataSetChanged();
                    editTextMessage.setText("");
                    
                    ListChat.scrollToPosition(chatDataModelsList.size() - 1);
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                chatDataModelsList.clear();
                chatAdapter.notifyDataSetChanged();
            }
        });
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a", Locale.getDefault());
        return sdf.format(new Date());
    }
}
