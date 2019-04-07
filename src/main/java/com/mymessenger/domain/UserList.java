//package com.mymessenger.domain;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "userlist")
//public class UserList {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @ManyToMany(mappedBy = "chatM")
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToMany
//    @JoinColumn(name = "ch_id")
//    private ChatM chatM;
//
//    public UserList() {
//    }
//
//    public UserList(User user, ChatM chatM) {
//        this.user = user;
//        this.chatM = chatM;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public ChatM getChatM() {
//        return chatM;
//    }
//
//    public void setChatM(ChatM chatM) {
//        this.chatM = chatM;
//    }
//}
