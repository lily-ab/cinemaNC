package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "raw", schema = "dbcinema", catalog = "")
public class RawEntity {
    private int idRaw;
    private int number;
    private int idHall;
    private Collection<PriceEntity> pricesByIdRaw;
    private HallEntity hallByIdHall;
    private Collection<SeatEntity> seatsByIdRaw;
    private Collection<TicketEntity> ticketsByIdRaw;

    @Id
    @Column(name = "id_Raw", nullable = false)
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
        RawEntity rawEntity = (RawEntity) o;
        return idRaw == rawEntity.idRaw &&
                number == rawEntity.number &&
                idHall == rawEntity.idHall;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRaw, number, idHall);
    }

    @OneToMany(mappedBy = "rawByIdRaw")
    public Collection<PriceEntity> getPricesByIdRaw() {
        return pricesByIdRaw;
    }

    public void setPricesByIdRaw(Collection<PriceEntity> pricesByIdRaw) {
        this.pricesByIdRaw = pricesByIdRaw;
    }

    @ManyToOne
    @JoinColumn(name = "id_Hall", referencedColumnName = "id_hall", nullable = false)
    public HallEntity getHallByIdHall() {
        return hallByIdHall;
    }

    public void setHallByIdHall(HallEntity hallByIdHall) {
        this.hallByIdHall = hallByIdHall;
    }

    @OneToMany(mappedBy = "rawByIdRaw")
    public Collection<SeatEntity> getSeatsByIdRaw() {
        return seatsByIdRaw;
    }

    public void setSeatsByIdRaw(Collection<SeatEntity> seatsByIdRaw) {
        this.seatsByIdRaw = seatsByIdRaw;
    }

    @OneToMany(mappedBy = "rawByIdRaw")
    public Collection<TicketEntity> getTicketsByIdRaw() {
        return ticketsByIdRaw;
    }

    public void setTicketsByIdRaw(Collection<TicketEntity> ticketsByIdRaw) {
        this.ticketsByIdRaw = ticketsByIdRaw;
    }


}
