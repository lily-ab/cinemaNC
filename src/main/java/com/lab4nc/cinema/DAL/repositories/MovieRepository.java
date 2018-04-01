package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.MovieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository  extends CrudRepository<MovieEntity,Integer>{
    @Query("select u from MovieEntity u where dateOfStart<=current_date and dateOfFinish>=current_date ")
    List<MovieEntity> findMovies();
    List<MovieEntity> findAll();
}
