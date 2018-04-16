package com.lab4nc.cinema.DAL.Models;

import com.lab4nc.cinema.DAL.Entities.TicketEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collection;
@Component
public class ReservationModel {
    private int sum;
    private Byte cancelled;
    private String phone;
    private Collection<TicketEntity> ticketsReservation;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Byte getCancelled() {
        return cancelled;
    }

    public void setCancelled(Byte cancelled) {
        this.cancelled = cancelled;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<TicketEntity> getTicketsReservation() {
        return ticketsReservation;
    }

    public void setTicketsReservation(Collection<TicketEntity> ticketsReservation) {
        this.ticketsReservation = ticketsReservation;
    }
}
