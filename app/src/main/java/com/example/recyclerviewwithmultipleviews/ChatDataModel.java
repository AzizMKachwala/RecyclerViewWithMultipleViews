package com.example.recyclerviewwithmultipleviews;

public class ChatDataModel {

    String msg;

    String time;

    String type;

    public ChatDataModel(String msg, String time, String type) {
        this.msg = msg;
        this.time = time;
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }
}
