package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author JuanLv created at 2023/8/28
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private long userId;
    private String userName;

    public User() {
    }

    public User(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
