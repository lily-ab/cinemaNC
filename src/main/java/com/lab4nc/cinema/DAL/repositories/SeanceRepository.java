package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import com.lab4nc.cinema.DAL.Entities.SeatEntity;
import com.lab4nc.cinema.DAL.Entities.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeanceRepository extends CrudRepository<SeanceEntity,Integer> {
}
