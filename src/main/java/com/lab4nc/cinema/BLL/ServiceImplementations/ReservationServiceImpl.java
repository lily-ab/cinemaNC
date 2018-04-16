package com.lab4nc.cinema.BLL.ServiceImplementations;

import com.lab4nc.cinema.BLL.Services.PriceService;
import com.lab4nc.cinema.BLL.Services.ReservationService;
import com.lab4nc.cinema.DAL.Entities.ReservationEntity;
import com.lab4nc.cinema.DAL.Entities.TicketEntity;
import com.lab4nc.cinema.DAL.Models.ReservationModel;
import com.lab4nc.cinema.DAL.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.List;
@Repository
@Transactional
@Component
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservation;

    @Override
    public ReservationEntity addReservation(ReservationModel model){
        ReservationEntity ent=new ReservationEntity();
        List<TicketEntity> tickets= (List<TicketEntity>) model.getTicketsReservation();
        Date date=new Date();
        ent.setDate(date);
        ent.setPhone(model.getPhone());
        ent.setTicketsByIdReservation(tickets);
        ent.setSum(model.getSum());
        reservation.save(ent);
        int id=reservation.getSaved();
        return reservation.findOne(id);
    }

    @Override
    public ReservationEntity find(int id){
        return reservation.findOne(id);
    }
}
