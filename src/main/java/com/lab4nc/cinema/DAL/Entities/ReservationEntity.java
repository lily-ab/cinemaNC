package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "dbcinema", catalog = "")
public class ReservationEntity {
    private int idReservation;
    private int sum;
    private Date date;
    private long time;
    private String phone;
    private Collection<TicketEntity> ticketsByIdReservation;

    @Id
    @Column(name = "id_Reservation", nullable = false)
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "sum", nullable = false)
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return idReservation == that.idReservation &&
                sum == that.sum &&
                Objects.equals(date, that.date) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idReservation, sum, date, phone);
    }

    @OneToMany(mappedBy = "reservationByIdReservation")
    public Collection<TicketEntity> getTicketsByIdReservation() {
        return ticketsByIdReservation;
    }

    public void setTicketsByIdReservation(Collection<TicketEntity> ticketsByIdReservation) {
        this.ticketsByIdReservation = ticketsByIdReservation;
    }
}
