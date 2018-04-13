package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.RawEntity;
import com.lab4nc.cinema.DAL.Models.HallSchemaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RawRepository extends CrudRepository<RawEntity,Integer> {
    @Query("select u from RawEntity u where u.idHall=:id ")
    List<RawEntity> findRaws(@Param("id")int id);
}
