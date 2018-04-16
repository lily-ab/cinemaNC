package com.lab4nc.cinema.BLL.Services;

import com.lab4nc.cinema.DAL.Entities.ReservationEntity;
import com.lab4nc.cinema.DAL.Models.ReservationModel;

public interface ReservationService {
    public ReservationEntity addReservation(ReservationModel model);
    ReservationEntity find(int id);
}
