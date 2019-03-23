package com.mymessenger.domain;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table (name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ch_id;
    private String ch_name;
    private int userId;
    private Time chat_c;

    public Chat() {
    }

    public Chat(String ch_name, int userId, Time chat_c) {
        this.ch_name = ch_name;
        this.userId = userId;
        this.chat_c = chat_c;
    }

    public int getCh_id() {
        return ch_id;
    }

    public String getCh_name() {
        return ch_name;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Time getChat_c() {
        return chat_c;
    }

    public void setChat_c(Time chat_c) {
        this.chat_c = chat_c;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "ch_id=" + ch_id +
                ", ch_name='" + ch_name + '\'' +
                ", userId=" + userId +
                ", chat_c=" + chat_c +
                '}';
    }
}
