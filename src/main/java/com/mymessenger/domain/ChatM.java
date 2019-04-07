package com.mymessenger.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "chatm")
public class ChatM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch_idm")
    private Long chIdM;

    @Column(name = "ch_name")
    private String chName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User authorM;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "chatm_user", joinColumns = { @JoinColumn(name = "CH_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<User> users= new HashSet<User>(0);



    public ChatM() {
    }

//    public ChatM(String chName, User authorM) {
//        this.chName = chName;
//        this.authorM = authorM;
//
//    }

    public ChatM(String chName, User authorM, Set<User> users) {
        this.chName = chName;
        this.authorM = authorM;
        this.users = users;
    }
    //    public void addUser(ChatM chatM,User user){
//        chatM.getUserList().add(user);
//    }
//
//    public void deleteUser(ChatM chatM,User user){
//        chatM.getUserList().remove(user);
//    }


    public String getAuthorMn(){
        return authorM.getUsername();
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public User getAuthorM() {
        return authorM;
    }

    public void setAuthorM(User authorM) {
        this.authorM = authorM;
    }


    public Long getChIdM() {
        return chIdM;
    }

    public void setChIdM(Long chIdM) {
        this.chIdM = chIdM;
    }



    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }




}




