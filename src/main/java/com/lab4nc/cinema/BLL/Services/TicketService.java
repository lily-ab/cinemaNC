package com.lab4nc.cinema.BLL.Services;

import com.lab4nc.cinema.DAL.Entities.SeatEntity;

import java.util.List;

public interface TicketService {
    List<SeatEntity> getSeatsBySeance(int id);
}
