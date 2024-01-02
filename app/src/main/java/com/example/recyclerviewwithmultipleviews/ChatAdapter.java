package com.example.recyclerviewwithmultipleviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<ChatDataModel> chatDataModelsList;
    Context context;

    public ChatAdapter(List<ChatDataModel> chatDataModels, Context context) {
        this.chatDataModelsList = chatDataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder vh = null;
        if (viewType == 0) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.my_msg_item, parent, false);
            vh = new MyMsgViewHolder(view);
        } else {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.other_msg_item, parent, false);
            vh = new OtherMsgViewHolder(view);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof MyMsgViewHolder) {
            ((MyMsgViewHolder) holder).MyMsg.setText(chatDataModelsList.get(position).getMsg());
            ((MyMsgViewHolder) holder).MyMsgTime.setText(chatDataModelsList.get(position).getTime());
        } else {
            ((OtherMsgViewHolder) holder).OtherMsg.setText(chatDataModelsList.get(position).getMsg());
            ((OtherMsgViewHolder) holder).OtherMsgTime.setText(chatDataModelsList.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return chatDataModelsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type = Integer.parseInt(chatDataModelsList.get(position).getType());
        return type;
    }

    public class MyMsgViewHolder extends ViewHolder {
        TextView MyMsg, MyMsgTime;

        public MyMsgViewHolder(@NonNull View itemView) {
            super(itemView);
            MyMsg = itemView.findViewById(R.id.MyMsg);
            MyMsgTime = itemView.findViewById(R.id.MyMsgTime);
        }
    }

    public class OtherMsgViewHolder extends ViewHolder {
        TextView OtherMsg, OtherMsgTime;

        public OtherMsgViewHolder(@NonNull View itemView) {
            super(itemView);
            OtherMsg = itemView.findViewById(R.id.OtherMsg);
            OtherMsgTime = itemView.findViewById(R.id.OtherMsgTime);
        }
    }
}
