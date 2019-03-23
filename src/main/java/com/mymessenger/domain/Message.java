package com.mymessenger.domain;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table (name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int m_id;
    private String content;
    private int senderId;
    private int chatId;
    private Time timeCreate;



    public Message() {
    }

    public Message(String content, int senderId, int chatId, Time timeCreate) {
        this.content = content;
        this.senderId = senderId;
        this.chatId = chatId;
        this.timeCreate = timeCreate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getM_id() {
        return m_id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public Time getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Time timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "m_id=" + m_id +
                ", senderId=" + senderId +
                ", chatId=" + chatId +
                ", timeCreate=" + timeCreate +
                '}';
    }
}
