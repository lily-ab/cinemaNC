package com.lab4nc.cinema.BLL.ServiceImplementations;

import com.lab4nc.cinema.BLL.Services.RawService;
import com.lab4nc.cinema.DAL.Entities.RawEntity;
import com.lab4nc.cinema.DAL.Models.HallSchemaModel;
import com.lab4nc.cinema.DAL.repositories.RawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@Component
public class RawServiceImpl  implements RawService{
    @Autowired
    RawRepository rawRep;
    @Override
    public List<RawEntity> getRaws(int id){
        return rawRep.findRaws(id);
    }
}
