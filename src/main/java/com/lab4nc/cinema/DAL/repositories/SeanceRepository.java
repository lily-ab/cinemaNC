package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import org.springframework.data.repository.CrudRepository;

public interface SeanceRepository extends CrudRepository<SeanceEntity,Integer> {
}
