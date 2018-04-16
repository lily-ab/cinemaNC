package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.ReservationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity,Integer> {
    @Query("SELECT MAX(u.idReservation) FROM ReservationEntity u")
    int getSaved();
}
