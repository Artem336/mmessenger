package com.mymessenger.domain;

import javax.persistence.*;


@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;

    private String u_name;
    private String login;
    private String password;

    public User() {
    }

    public User(String name, String login, String password) {
        this.u_name = name;
        this.login = login;
        this.password = password;
    }

    public int getU_id() {
        return u_id;
    }

    public String getName() {
        return u_name;
    }

    public void setName(String name) {
        this.u_name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }


}