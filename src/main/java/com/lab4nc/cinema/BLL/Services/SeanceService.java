package com.lab4nc.cinema.BLL.Services;

import com.lab4nc.cinema.DAL.Entities.SeanceEntity;

import java.util.List;

public interface SeanceService {
    List<SeanceEntity> findAll();
    SeanceEntity find(int id);
}
