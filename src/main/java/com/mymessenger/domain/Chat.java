package com.mymessenger.domain;

import javax.persistence.*;
//import java.sql.Time;

@Entity
@Table (name = "chatt")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch_id")
    private Long chId;
    private String ch_name;
//    private Long userId;
    private Long addresseeId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


//    private Time chat_c;


    public Chat() {
    }

    public Chat( User user, Long addresseeId) {
        this.author = user;
        this.addresseeId=addresseeId;

    }

    public String getAuthorn(){
        return author.getUsername();
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public Long getAddresseeId() {
        return addresseeId;
    }

    public void setAddresseeId(Long addresseeId) {
        this.addresseeId = addresseeId;
    }

    public Long getChId() {
        return chId;
    }

    public void setChId(Long ch_id) {
        this.chId = chId;
    }

    public String getCh_name() {
        return ch_name;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//    public Time getChat_c() {
//        return chat_c;
//    }
//
//    public void setChat_c(Time chat_c) {
//        this.chat_c = chat_c;
//    }


}
