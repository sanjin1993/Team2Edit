package com.edit.viberBot.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Routes")
public class Route {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    @Id
    private Integer id;

    @Column(name = "Start")
    private String start;

    public String getViberId() {
        return viberId;
    }

    public void setViberId(String viberId) {
        this.viberId = viberId;
    }

    @Column(name = "viberId")
    private String viberId;

    @Column(name = "Destination")
    private String destination ;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Time")
    private LocalTime time;

    @Column(name = "AvailableSeats")
    private int availableSeats;

    @OneToMany(mappedBy = "route")
    private List<Reservation> reservationList;

    public Route(String sta , String dest , LocalDate dat , LocalTime tim , int availableSeat)
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

    @OneToMany(mappedBy = "route")
    List<Reservation> reservations;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id" , referencedColumnName = "route_id")
    private List<Reservation> reservationList;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Start: " + this.getStart() + "  Destination: " + this.getDestination() + " Datum " + this.getDate()+ " Time" + this.getTime()
                + "Available seats: "+this.getAvailableSeats();
    }
}
