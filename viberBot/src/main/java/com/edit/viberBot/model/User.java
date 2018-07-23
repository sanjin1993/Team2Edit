package com.edit.viberBot.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.websocket.OnError;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "viberId")
    private String viberId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Subscribed")
    private boolean subscribed;


    @OneToMany(mappedBy="user")
    private List<Reservation> reservationList;


    public User()
    {

    }
    public User(String viberId , String name , boolean Subsribed)
    {
        this.viberId = viberId;
        this.name = name;
        this.subscribed = Subsribed;
    }



    public String getViberId() {
        return viberId;
    }

    public void setViberId(String viberId) {
        viberId = viberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        subscribed = subscribed;
    }


    public boolean isSubscribed() {
        return subscribed;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }
}