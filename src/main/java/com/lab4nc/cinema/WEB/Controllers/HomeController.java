package com.lab4nc.cinema.WEB.Controllers;


import com.lab4nc.cinema.BLL.ServiceImplementations.MovieServiceImpl;
import com.lab4nc.cinema.BLL.Services.MovieService;
import com.lab4nc.cinema.DAL.Entities.MovieEntity;
import com.lab4nc.cinema.DAL.Entities.SeanceEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {
    MovieService mov;

    HomeController(MovieServiceImpl mov){
        this.mov=mov;
    }

    @RequestMapping(value = {"/","/index" }, method= RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("movies", mov.findMovies());
        return "index";
    }

    @RequestMapping(value = {"/movie/{id}" }, method= RequestMethod.GET)
    public String getMovie(@PathVariable int id, ModelMap model){
        MovieEntity movie=mov.find(id);
        List<SeanceEntity> seances = (List<SeanceEntity>) movie.getSeancesByIdMovie();

        model.addAttribute("movie", movie)
        .addAttribute("seances",seances);
        return "movie";
    }
}
