package com.lab4nc.cinema.DAL.repositories;

import com.lab4nc.cinema.DAL.Entities.PriceEntity;
import com.lab4nc.cinema.DAL.Models.HallSchemaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends CrudRepository<PriceEntity,Integer> {
//
//    @Query("select  r.idRaw,r.number, r.idHall,p.price from PriceEntity p  \n" +
//            "join p.rawByIdRaw r where r.idHall=:id")
//    List<HallSchemaModel> findRawAndPrices(@Param("id")int id);

    @Query("select p.price from PriceEntity p where p.idSeance=:idSeance and p.idRaw=:idRaw")
    String getPrice(@Param("idSeance") int idSeance, @Param("idRaw")int idRaw);
}
