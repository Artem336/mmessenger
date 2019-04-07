package com.mymessenger.domain;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table (name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_id;

    private String content;
//    private Long senderId;
    @Column(name = "chat_id")
    private Long chatId;
//    private Time timeCreate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    public Message() {
    }

    public Message(String content, User user, Long chatId) {
        this.content = content;
        this.chatId = chatId;
        this.author =user;
//        this.timeCreate = timeCreate;
    }

    public String getAuthorNam(){
        return author !=null ? author.getUsername(): "<none>";
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getM_id() {
        return m_id;
    }

//    public Long getSenderId() {
//        return senderId;
//    }
//
//    public void setSenderId(Long senderId) {
//        this.senderId = senderId;
//    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

//    public Time getTimeCreate() {
//        return timeCreate;
//    }
//
//    public void setTimeCreate(Time timeCreate) {
//        this.timeCreate = timeCreate;
//    }


}
