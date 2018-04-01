package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "price", schema = "dbcinema", catalog = "")
public class PriceEntity {
    private int idPrice;
    private int idSeance;
    private int idRaw;
    private int price;
    private SeanceEntity seanceByIdSeance;
    private RawEntity rawByIdRaw;
    private Collection<TicketEntity> ticketsByIdPrice;

    @Id
    @Column(name = "id_Price", nullable = false)
    public int getIdPrice() {
        return idPrice;
    }

    public void setIdPrice(int idPrice) {
        this.idPrice = idPrice;
    }

    @Basic
    @Column(name = "id_Seance", nullable = false, insertable = false, updatable = false)
    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
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
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceEntity that = (PriceEntity) o;
        return idPrice == that.idPrice &&
                idSeance == that.idSeance &&
                idRaw == that.idRaw &&
                price == that.price;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPrice, idSeance, idRaw, price);
    }

    @ManyToOne
    @JoinColumn(name = "id_Seance", referencedColumnName = "id_Seance", nullable = false)
    public SeanceEntity getSeanceByIdSeance() {
        return seanceByIdSeance;
    }

    public void setSeanceByIdSeance(SeanceEntity seanceByIdSeance) {
        this.seanceByIdSeance = seanceByIdSeance;
    }

    @ManyToOne
    @JoinColumn(name = "id_Raw", referencedColumnName = "id_Raw", nullable = false)
    public RawEntity getRawByIdRaw() {
        return rawByIdRaw;
    }

    public void setRawByIdRaw(RawEntity rawByIdRaw) {
        this.rawByIdRaw = rawByIdRaw;
    }

    @OneToMany(mappedBy = "priceByIdPrice")
    public Collection<TicketEntity> getTicketsByIdPrice() {
        return ticketsByIdPrice;
    }

    public void setTicketsByIdPrice(Collection<TicketEntity> ticketsByIdPrice) {
        this.ticketsByIdPrice = ticketsByIdPrice;
    }
}
