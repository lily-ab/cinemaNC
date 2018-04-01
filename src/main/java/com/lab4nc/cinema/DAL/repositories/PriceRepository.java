package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.PriceEntity;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<PriceEntity,Integer> {
}
