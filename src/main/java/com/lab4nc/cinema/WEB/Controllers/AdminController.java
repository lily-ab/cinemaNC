package com.lab4nc.cinema.WEB.Controllers;

import com.lab4nc.cinema.BLL.ServiceImplementations.MovieServiceImpl;
import com.lab4nc.cinema.BLL.Services.MovieService;
import com.lab4nc.cinema.DAL.Entities.MovieEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AdminController {
    MovieService mov;

    AdminController(MovieServiceImpl mov){
        this.mov=mov;
    }

    @RequestMapping(value = {"/admin" }, method= RequestMethod.GET)
    public String movieList(Model model){
        model.addAttribute("movies", mov.findAll());
        return "admin";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("movie", new MovieEntity());
        return "addMovie";
    }

    @PostMapping("/add")
    public String add(@Valid MovieEntity movie, BindingResult result) {

        if (result.hasErrors()) {
            return "addMovie";
        }
        mov.add(movie);
        return "redirect:/";
    }

    @RequestMapping(value = {"/deleteMovie/{id}" }, method= RequestMethod.GET)
    public String delete(@PathVariable int id) {

        mov.delete(id);

        return "redirect:/admin";
    }

//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model) {
//        MovieEntity movie = mov.find(id);
//        model.addAttribute("movie", movie);
//        return "/editMovie";
//    }
//
//    @PostMapping("/edit")
//    public String saveNote(@RequestParam Integer id, @RequestParam String message,
//                           @RequestParam(value = "done", required = false) boolean done) {
//        service.updateNote(id, message, done);
//        return "redirect:/";
//    }
}
