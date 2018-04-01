package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "seance", schema = "dbcinema", catalog = "")
public class SeanceEntity {
    private int idSeance;
    private int idHall;
    private int idMovie;
    private Date date;
    private Time time;
    private Collection<PriceEntity> pricesByIdSeance;
    private HallEntity hallByIdHall;
    private MovieEntity movieByIdMovie;
    private Collection<TicketEntity> ticketsByIdSeance;

    @Id
    @Column(name = "id_Seance", nullable = false)
    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    @Basic
    @Column(name = "id_Hall", nullable = false, insertable = false, updatable = false)
    public int getIdHall() {
        return idHall;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    @Basic
    @Column(name = "id_Movie", nullable = false, insertable = false, updatable = false)
    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
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
    @Column(name = "time", nullable = false)
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeanceEntity that = (SeanceEntity) o;
        return idSeance == that.idSeance &&
                idHall == that.idHall &&
                idMovie == that.idMovie &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSeance, idHall, idMovie, date, time);
    }

    @OneToMany(mappedBy = "seanceByIdSeance")
    public Collection<PriceEntity> getPricesByIdSeance() {
        return pricesByIdSeance;
    }

    public void setPricesByIdSeance(Collection<PriceEntity> pricesByIdSeance) {
        this.pricesByIdSeance = pricesByIdSeance;
    }

    @ManyToOne
    @JoinColumn(name = "id_Hall", referencedColumnName = "id_hall", nullable = false)
    public HallEntity getHallByIdHall() {
        return hallByIdHall;
    }

    public void setHallByIdHall(HallEntity hallByIdHall) {
        this.hallByIdHall = hallByIdHall;
    }

    @ManyToOne
    @JoinColumn(name = "id_Movie", referencedColumnName = "id_Movie", nullable = false)
    public MovieEntity getMovieByIdMovie() {
        return movieByIdMovie;
    }

    public void setMovieByIdMovie(MovieEntity movieByIdMovie) {
        this.movieByIdMovie = movieByIdMovie;
    }

    @OneToMany(mappedBy = "seanceByIdSeance")
    public Collection<TicketEntity> getTicketsByIdSeance() {
        return ticketsByIdSeance;
    }

    public void setTicketsByIdSeance(Collection<TicketEntity> ticketsByIdSeance) {
        this.ticketsByIdSeance = ticketsByIdSeance;
    }
}
