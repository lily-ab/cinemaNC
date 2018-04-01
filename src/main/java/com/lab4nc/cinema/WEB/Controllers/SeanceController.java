package com.lab4nc.cinema.WEB.Controllers;

import com.lab4nc.cinema.BLL.ServiceImplementations.SeanceServiceImpl;
import com.lab4nc.cinema.BLL.Services.SeanceService;
import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SeanceController {
    SeanceService seance;
    SeanceController(SeanceServiceImpl seance){
        this.seance=seance;
    }

    @RequestMapping(value = {"/seance/{id}" }, method= RequestMethod.GET)
    public String getMovie(@PathVariable int id, ModelMap model){
        SeanceEntity s=seance.find(id);
        model.addAttribute("seance", s);
        return "seance";
    }
}
