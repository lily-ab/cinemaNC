package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.SeatEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<SeatEntity,Integer> {

}
