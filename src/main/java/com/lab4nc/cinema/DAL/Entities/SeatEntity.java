package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "seat", schema = "dbcinema", catalog = "")
public class SeatEntity {
    private int idSeat;
    private int idRaw;
    private int number;
    private int idHall;
    private RawEntity rawByIdRaw;
    private HallEntity hallByIdHall;
    private Collection<TicketEntity> ticketsByIdSeat;

    @Id
    @Column(name = "id_Seat", nullable = false)
    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    @Basic
    @Column(name = "id_Raw", nullable = false, insertable = false, updatable = false)
    public int getIdRaw() {
        return idRaw;
    }

    public void setIdRaw(int idRaw) {
        this.idRaw = idRaw;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "id_Hall", nullable = false, insertable = false, updatable = false)
    public int getIdHall() {
        return idHall;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatEntity that = (SeatEntity) o;
        return idSeat == that.idSeat &&
                idRaw == that.idRaw &&
                number == that.number &&
                idHall == that.idHall;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSeat, idRaw, number, idHall);
    }

    @ManyToOne
    @JoinColumn(name = "id_Raw", referencedColumnName = "id_Raw", nullable = false)
    public RawEntity getRawByIdRaw() {
        return rawByIdRaw;
    }

    public void setRawByIdRaw(RawEntity rawByIdRaw) {
        this.rawByIdRaw = rawByIdRaw;
    }

    @ManyToOne
    @JoinColumn(name = "id_Hall", referencedColumnName = "id_hall", nullable = false)
    public HallEntity getHallByIdHall() {
        return hallByIdHall;
    }

    public void setHallByIdHall(HallEntity hallByIdHall) {
        this.hallByIdHall = hallByIdHall;
    }

    @OneToMany(mappedBy = "seatByIdSeat")
    public Collection<TicketEntity> getTicketsByIdSeat() {
        return ticketsByIdSeat;
    }

    public void setTicketsByIdSeat(Collection<TicketEntity> ticketsByIdSeat) {
        this.ticketsByIdSeat = ticketsByIdSeat;
    }
}
