package com.lab4nc.cinema.BLL.ServiceImplementations;

import com.lab4nc.cinema.BLL.Services.PriceService;
import com.lab4nc.cinema.DAL.Entities.PriceEntity;
import com.lab4nc.cinema.DAL.Models.HallSchemaModel;
import com.lab4nc.cinema.DAL.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Component
public class PriceServiceImpl implements PriceService{
    @Autowired
    PriceRepository priceRep;
//    @Override
//    public List<HallSchemaModel> getRawsAndPrices(int id){
//        return priceRep.findRawAndPrices(id);
//    }
    @Override
    public String getPrice(int idSeance,int idRaw){
        return priceRep.getPrice(idSeance,idRaw);
    }
}
