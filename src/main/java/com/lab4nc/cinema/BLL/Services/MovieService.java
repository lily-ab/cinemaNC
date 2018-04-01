package com.lab4nc.cinema.BLL.Services;

import com.lab4nc.cinema.DAL.Entities.MovieEntity;
import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieService {
    List<MovieEntity> findMovies();
    List<MovieEntity> findAll();
    MovieEntity find(int id);
    List<SeanceEntity> getSeances(int id);
    void add(MovieEntity movie);
    void delete(int id);
}
