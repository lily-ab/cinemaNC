package com.lab4nc.cinema.BLL.ServiceImplementations;

import com.google.inject.internal.util.Lists;
import com.lab4nc.cinema.BLL.Services.MovieService;
import com.lab4nc.cinema.DAL.Entities.MovieEntity;
import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.lab4nc.cinema.DAL.repositories.MovieRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Component
@EnableAutoConfiguration
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRep;

    @Override
    public List<MovieEntity> findAll() {
        return Lists.newArrayList(movieRep.findAll());
    }

    @Override
    public List<MovieEntity> findMovies(){return Lists.newArrayList(movieRep.findMovies());}
    @Override
    public MovieEntity find(int id){
        return movieRep.findOne(id);
    }

    @Override
    public List<SeanceEntity> getSeances(int id){
        return Lists.newArrayList(movieRep.findOne(id).getSeancesByIdMovie());
    }

    @Override
    public void add(MovieEntity movie){
        movieRep.save(movie);
    }

    @Override
    public void delete(int id){
        movieRep.delete(id);
    }
}
