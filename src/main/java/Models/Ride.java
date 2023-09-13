package Models;

import com.sun.javafx.beans.IDProperty;

public class Ride {


    int id;

    User offeredBy;

    User takenBy;

    String origin;

    String destination;

    Vehicle vehicle;

    int seats;

    public Ride(int id, User offeredBy, User takenBy, String origin, String destination, Vehicle vehicle, int seats) {
        this.id = id;
        this.offeredBy = offeredBy;
        this.takenBy = takenBy;
        this.origin = origin;
        this.destination = destination;
        this.vehicle = vehicle;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(User offeredBy) {
        this.offeredBy = offeredBy;
    }

    public User getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(User takenBy) {
        this.takenBy = takenBy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
