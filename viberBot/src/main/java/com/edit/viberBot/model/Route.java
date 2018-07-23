package com.edit.viberBot.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Routes")
public class Route {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    @Id
    private int id;

    @Column(name = "Start")
    private String start;

    @Column(name = "Destination")
    private String destination ;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Time")
    private Time time;

    @Column(name = "AvailableSeats")
    private int availableSeats;

    @OneToMany(mappedBy = "route")
    private List<Reservation> reservationList;

    public Route(String sta , String dest , Date dat , Time tim , int availableSeat)
    {
        this.start = sta;
        this.destination = dest;
        this.date = dat;
        this.time = tim;
        this.availableSeats = availableSeat;
    }
    public Route()
    {

    }
 /*   @OneToMany(mappedBy = "route")
    List<Reservation> reservations;*/

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id" , referencedColumnName = "route_id")
    private List<Reservation> reservationList;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        destination = destination;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        date = date;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        time = time;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        availableSeats = availableSeats;
    }

}
