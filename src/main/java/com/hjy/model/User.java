package com.hjy.model;

import java.io.Serializable;

/**
 * 管理员实体类
 * @author hjy
 * @create 2017/11/27
 **/
public class User implements Serializable{
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
