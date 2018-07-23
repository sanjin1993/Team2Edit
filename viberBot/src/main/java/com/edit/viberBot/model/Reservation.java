package com.edit.viberBot.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "Reservations")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "reservation_id")
    private int id;

   @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "route_id")
   Route route;

    /* Route route;*/
   /* @Column(name="RouteId")
    private int route_id;*/

    @Column(name = "ReservedSeats")
    private int reservedSeats;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    public Reservation()
    {

    }
    public Reservation(Route route, int reservedSeats, User user) {
        this.route = route;
        this.reservedSeats = reservedSeats;
        this.user = user;
    }

    /*public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }
*/

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , referencedColumnName = "user_id")
    private User users;*/

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "routes_id" , referencedColumnName = "routes_id")
    private Route routes;*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Route getRoute()
    {
        return route;
    }
    public void setRoute(Route route)
    {
        this.route=route;
    }



}
