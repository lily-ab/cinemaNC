package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "hall", schema = "dbcinema", catalog = "")
public class HallEntity {
    private int idHall;
    private String name;
    private String description;
    private Collection<RawEntity> rawsByIdHall;
    private Collection<SeanceEntity> seancesByIdHall;
    private Collection<SeatEntity> seatsByIdHall;
    private Collection<TicketEntity> ticketsByIdHall;

    @Id
    @Column(name = "id_hall", nullable = false)
    public int getIdHall() {
        return idHall;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallEntity that = (HallEntity) o;
        return idHall == that.idHall &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idHall, name, description);
    }

    @OneToMany(mappedBy = "hallByIdHall")
    public Collection<RawEntity> getRawsByIdHall() {
        return rawsByIdHall;
    }

    public void setRawsByIdHall(Collection<RawEntity> rawsByIdHall) {
        this.rawsByIdHall = rawsByIdHall;
    }

    @OneToMany(mappedBy = "hallByIdHall")
    public Collection<SeanceEntity> getSeancesByIdHall() {
        return seancesByIdHall;
    }

    public void setSeancesByIdHall(Collection<SeanceEntity> seancesByIdHall) {
        this.seancesByIdHall = seancesByIdHall;
    }

    @OneToMany(mappedBy = "hallByIdHall")
    public Collection<SeatEntity> getSeatsByIdHall() {
        return seatsByIdHall;
    }

    public void setSeatsByIdHall(Collection<SeatEntity> seatsByIdHall) {
        this.seatsByIdHall = seatsByIdHall;
    }

    @OneToMany(mappedBy = "hallByIdHall")
    public Collection<TicketEntity> getTicketsByIdHall() {
        return ticketsByIdHall;
    }

    public void setTicketsByIdHall(Collection<TicketEntity> ticketsByIdHall) {
        this.ticketsByIdHall = ticketsByIdHall;
    }
}
