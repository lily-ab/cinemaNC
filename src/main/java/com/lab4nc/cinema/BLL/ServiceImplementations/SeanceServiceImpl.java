package com.lab4nc.cinema.BLL.ServiceImplementations;

import com.google.inject.internal.util.Lists;
import com.lab4nc.cinema.BLL.Services.SeanceService;
import com.lab4nc.cinema.DAL.Entities.RawEntity;
import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import com.lab4nc.cinema.DAL.Entities.SeatEntity;
import com.lab4nc.cinema.DAL.Entities.TicketEntity;
import com.lab4nc.cinema.DAL.repositories.RawRepository;
import com.lab4nc.cinema.DAL.repositories.SeanceRepository;
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
public class SeanceServiceImpl implements SeanceService {
    @Autowired
    SeanceRepository seanceRep;
    @Override
    public List<SeanceEntity> findAll() {
        return Lists.newArrayList(seanceRep.findAll());
    }

    @Override
    public SeanceEntity find(int id) {
        return seanceRep.findOne(id);
    }

}
