package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "dbcinema", catalog = "")
public class TicketEntity {
    private int idTicket;
    private int idSeance;
    private int idHall;
    private int idRaw;
    private int idSeat;
    private int idPrice;
    private int idReservation;
    private SeanceEntity seanceByIdSeance;
    private HallEntity hallByIdHall;
    private RawEntity rawByIdRaw;
    private SeatEntity seatByIdSeat;
    private PriceEntity priceByIdPrice;
    private ReservationEntity reservationByIdReservation;

    @Id
    @Column(name = "id_Ticket", nullable = false)
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Basic
    @Column(name = "id_Seance", nullable = false)
    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    @Basic
    @Column(name = "id_Hall", nullable = false)
    public int getIdHall() {
        return idHall;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    @Basic
    @Column(name = "id_Raw", nullable = false)
    public int getIdRaw() {
        return idRaw;
    }

    public void setIdRaw(int idRaw) {
        this.idRaw = idRaw;
    }

    @Basic
    @Column(name = "id_Seat", nullable = false)
    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    @Basic
    @Column(name = "id_Price", nullable = true, insertable = false, updatable = false)
    public Integer getIdPrice() {
        return idPrice;
    }

    public void setIdPrice(Integer idPrice) {
        this.idPrice = idPrice;
    }

    @Basic
    @Column(name = "id_Reservation", nullable = false, insertable = false, updatable = false)
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return idTicket == that.idTicket &&
                idSeance == that.idSeance &&
                idHall == that.idHall &&
                idRaw == that.idRaw &&
                idSeat == that.idSeat &&
                idReservation == that.idReservation &&
                Objects.equals(idPrice, that.idPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTicket, idSeance, idHall, idRaw, idSeat, idPrice, idReservation);
    }

    @ManyToOne
    @JoinColumn(name = "id_Seance", referencedColumnName = "id_Seance", nullable = false, insertable = false, updatable = false)
    public SeanceEntity getSeanceByIdSeance() {
        return seanceByIdSeance;
    }

    public void setSeanceByIdSeance(SeanceEntity seanceByIdSeance) {
        this.seanceByIdSeance = seanceByIdSeance;
    }

    @ManyToOne
    @JoinColumn(name = "id_Hall", referencedColumnName = "id_hall", nullable = false, insertable = false, updatable = false)
    public HallEntity getHallByIdHall() {
        return hallByIdHall;
    }

    public void setHallByIdHall(HallEntity hallByIdHall) {
        this.hallByIdHall = hallByIdHall;
    }

    @ManyToOne
    @JoinColumn(name = "id_Raw", referencedColumnName = "id_Raw", nullable = false, insertable = false, updatable = false)
    public RawEntity getRawByIdRaw() {
        return rawByIdRaw;
    }

    public void setRawByIdRaw(RawEntity rawByIdRaw) {
        this.rawByIdRaw = rawByIdRaw;
    }

    @ManyToOne
    @JoinColumn(name = "id_Seat", referencedColumnName = "id_Seat", nullable = false, insertable = false, updatable = false)
    public SeatEntity getSeatByIdSeat() {
        return seatByIdSeat;
    }

    public void setSeatByIdSeat(SeatEntity seatByIdSeat) {
        this.seatByIdSeat = seatByIdSeat;
    }

    @ManyToOne
    @JoinColumn(name = "id_Price", referencedColumnName = "id_Price")
    public PriceEntity getPriceByIdPrice() {
        return priceByIdPrice;
    }

    public void setPriceByIdPrice(PriceEntity priceByIdPrice) {
        this.priceByIdPrice = priceByIdPrice;
    }

    @ManyToOne
    @JoinColumn(name = "id_Reservation", referencedColumnName = "id_Reservation", nullable = false)
    public ReservationEntity getReservationByIdReservation() {
        return reservationByIdReservation;
    }

    public void setReservationByIdReservation(ReservationEntity reservationByIdReservation) {
        this.reservationByIdReservation = reservationByIdReservation;
    }
}
