package com.lab4nc.cinema.BLL.Services;

import com.lab4nc.cinema.DAL.Entities.PriceEntity;
import com.lab4nc.cinema.DAL.Models.HallSchemaModel;

import java.util.List;

public interface PriceService {

    PriceEntity getPrice(int idSeance,int idRaw);
}
