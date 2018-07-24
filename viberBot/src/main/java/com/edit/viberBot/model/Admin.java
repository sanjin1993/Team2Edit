package com.edit.viberBot.model;

import javax.persistence.*;

@Entity
public class Admin
{
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Admin()
    {

    }
}
