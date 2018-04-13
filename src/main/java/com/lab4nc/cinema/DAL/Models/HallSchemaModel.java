package com.lab4nc.cinema.DAL.Models;

import com.lab4nc.cinema.DAL.Entities.SeatEntity;

import java.util.Collection;

public class HallSchemaModel {
    private int idRaw;
    private int number;
    private int idHall;
    private int price;
    private Collection<SeatEntity> seatsByIdRaw;

    public Collection<SeatEntity> getSeatsByIdRaw() {
        return seatsByIdRaw;
    }

    public void setSeatsByIdRaw(Collection<SeatEntity> seatsByIdRaw) {
        this.seatsByIdRaw = seatsByIdRaw;
    }

    public int getIdRaw() {
        return idRaw;
    }

    public void setIdRaw(int idRaw) {
        this.idRaw = idRaw;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIdHall() {
        return idHall;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
