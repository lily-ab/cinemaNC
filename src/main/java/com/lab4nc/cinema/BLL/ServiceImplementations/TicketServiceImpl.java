package com.lab4nc.cinema.BLL.ServiceImplementations;

import com.lab4nc.cinema.BLL.Services.TicketService;
import com.lab4nc.cinema.DAL.Entities.SeatEntity;
import com.lab4nc.cinema.DAL.Entities.TicketEntity;
import com.lab4nc.cinema.DAL.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@Component
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRep;

    @Override
    public List<SeatEntity> getSeatsBySeance(int id){
        List<TicketEntity> tickets=ticketRep.getTicketsBySeance(id);
        List<SeatEntity> seats = new ArrayList<>();
        for(TicketEntity ticket:tickets){
            seats.add(ticket.getSeatByIdSeat());
        }
        return seats;
    }
}
