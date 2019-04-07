//package com.mymessenger.domain;
//
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "message")
//public class Mtest {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer m_id;
//
//    private String content;
//    private Long chat_id;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User author;
//
//    public Mtest() { }
//
//    public Mtest(String content,User user,Long chat_id) {
//        this.content = content;
//        this.author=user;
//        this.chat_id=chat_id;
//    }
//
//    public String getAuthorn(){
//        return author !=null ? author.getUsername(): "<none>";
//    }
//
//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public Integer getM_id() {
//        return m_id;
//    }
//
//    public void setM_id(Integer m_id) {
//        this.m_id = m_id;
//    }
//
//
//}
