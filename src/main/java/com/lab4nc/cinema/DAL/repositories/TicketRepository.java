package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity,Integer> {
}
