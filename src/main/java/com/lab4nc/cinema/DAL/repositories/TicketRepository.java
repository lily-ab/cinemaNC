package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity,Integer> {
    @Query("select u from TicketEntity u where u.idSeance=:id")
    List<TicketEntity> getTicketsBySeance(@Param("id")int id);
}
