package com.lab4nc.cinema.WEB.Controllers;

import com.google.inject.internal.util.Lists;
import com.lab4nc.cinema.BLL.ServiceImplementations.PriceServiceImpl;
import com.lab4nc.cinema.BLL.ServiceImplementations.RawServiceImpl;
import com.lab4nc.cinema.BLL.ServiceImplementations.SeanceServiceImpl;
import com.lab4nc.cinema.BLL.ServiceImplementations.TicketServiceImpl;
import com.lab4nc.cinema.BLL.Services.PriceService;
import com.lab4nc.cinema.BLL.Services.RawService;
import com.lab4nc.cinema.BLL.Services.SeanceService;
import com.lab4nc.cinema.BLL.Services.TicketService;
import com.lab4nc.cinema.DAL.Entities.PriceEntity;
import com.lab4nc.cinema.DAL.Entities.RawEntity;
import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import com.lab4nc.cinema.DAL.Entities.SeatEntity;
import com.lab4nc.cinema.DAL.Models.HallSchemaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SeanceController {
    SeanceService seance;
    RawService raw;
    TicketService tick;
    PriceService price;
    SeanceController(SeanceServiceImpl seance, RawServiceImpl raw, TicketServiceImpl tick,
                     PriceServiceImpl price){
        this.seance=seance;
        this.raw=raw;
        this.tick=tick;
        this.price=price;
    }

    @RequestMapping(value = {"/seance/{id}" }, method= RequestMethod.GET)
    public String getSeance(@PathVariable int id, ModelMap model){
        SeanceEntity s=seance.find(id);
        List<RawEntity> raws=raw.getRaws(s.getIdHall());
        List<SeatEntity> takenSeats=tick.getSeatsBySeance(id);
        List<PriceEntity> prices= Lists.newArrayList(s.getPricesByIdSeance());

        model.addAttribute("seance", s)
                .addAttribute("raws",raws)
                .addAttribute("takenSeats",takenSeats)
                .addAttribute("prices",prices);
        return "seance";
    }

    public String getPrice(int idSeance, int idRaw){
        return price.getPrice(idSeance,idRaw);
    }
}
