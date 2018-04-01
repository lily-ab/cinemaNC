package com.lab4nc.cinema.DAL.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "movie", schema = "dbcinema", catalog = "")
public class MovieEntity {
    private int idMovie;
    private String name;
    private String genre;
    private Date dateOfStart;
    private Date dateOfFinish;
    private int duration;
    private String picture;
    private String description;
    private Collection<SeanceEntity> seancesByIdMovie;

    @Id
    @Column(name = "id_Movie", nullable = false)
    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
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
    @Column(name = "genre", nullable = true, length = 45)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "date_Of_Start", nullable = false)
    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    @Basic
    @Column(name = "date_Of_Finish", nullable = false)
    public Date getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(Date dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 45)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
        MovieEntity that = (MovieEntity) o;
        return idMovie == that.idMovie &&
                duration == that.duration &&
                Objects.equals(name, that.name) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(dateOfStart, that.dateOfStart) &&
                Objects.equals(dateOfFinish, that.dateOfFinish) &&
                Objects.equals(picture, that.picture) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMovie, name, genre, dateOfStart, dateOfFinish, duration, picture, description);
    }

    @OneToMany(mappedBy = "movieByIdMovie")
    public Collection<SeanceEntity> getSeancesByIdMovie() {
        return seancesByIdMovie;
    }

    public void setSeancesByIdMovie(Collection<SeanceEntity> seancesByIdMovie) {
        this.seancesByIdMovie = seancesByIdMovie;
    }
}
