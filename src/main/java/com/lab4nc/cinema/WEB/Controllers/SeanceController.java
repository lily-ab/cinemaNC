package com.lab4nc.cinema.WEB.Controllers;

import com.google.inject.internal.util.Lists;
import com.lab4nc.cinema.BLL.ServiceImplementations.*;
import com.lab4nc.cinema.BLL.Services.*;
import com.lab4nc.cinema.DAL.Entities.*;
import com.lab4nc.cinema.DAL.Models.ReservationModel;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value={"ReservationModel"})
@EnableWebSecurity(debug = false)
public class SeanceController {
    SeanceService seance;
    RawService raw;
    TicketService tick;
    PriceService price;
    ReservationService reservation;
    SeanceController(SeanceServiceImpl seance, RawServiceImpl raw, TicketServiceImpl tick,
                     PriceServiceImpl price, ReservationServiceImpl reservation){
        this.seance=seance;
        this.raw=raw;
        this.tick=tick;
        this.price=price;
        this.reservation=reservation;
    }


    @ModelAttribute("ReservationModel")
    public ReservationModel createReservationModel() {
        return new ReservationModel();
    }

    @GetMapping(value = {"/seance/{id}" })
    public String getSeance(@ModelAttribute("ReservationModel") ReservationModel reserv,
                            @PathVariable int id, ModelMap model){
        SeanceEntity s=seance.find(id);
        List<RawEntity> raws=raw.getRaws(s.getIdHall());
        List<SeatEntity> takenSeats=tick.getSeatsBySeance(id);
        List<PriceEntity> prices= Lists.newArrayList(s.getPricesByIdSeance());
        TicketEntity ticket=new TicketEntity();
        ticket.setIdSeance(id);
        ticket.setIdHall(s.getIdHall());
        model.addAttribute("seance", s)
                .addAttribute("raws",raws)
                .addAttribute("takenSeats",takenSeats)
                .addAttribute("prices",prices)
                .addAttribute("ticket",ticket)
                .addAttribute("reserv",reserv);
        return "seance";
    }
    @PostMapping("/getSeance")
    public String getSeance(@ModelAttribute("ReservationModel") ReservationModel reserv,
                               @Valid TicketEntity ticket, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "errorCreating";
        }
        ticket.setPriceByIdPrice(price.getPrice(ticket.getIdSeance(),ticket.getIdRaw()));
        List<TicketEntity> tickets= new ArrayList<>();
        if(reserv.getTicketsReservation()!=null) tickets.addAll(reserv.getTicketsReservation());
        tickets.add(ticket);
        reserv.setTicketsReservation(tickets);
        model.addAttribute("reservation",reserv);
        return "redirect:/confirming";
    }

    @RequestMapping(value = {"/confirming" }, method= RequestMethod.GET)
    public String confirming(@ModelAttribute("ReservationModel") ReservationModel reserv,ModelMap model){
        model.addAttribute("tickets",reserv.getTicketsReservation())
        .addAttribute("reservation", reserv);
        return "confirming";
    }

    @PostMapping(value = {"/confirming" })
    public String confirming(@ModelAttribute("ReservationModel") ReservationModel reserv,
                             ModelMap model,BindingResult result){
        if (result.hasErrors()) {
            return "errorCreating";
        }
        ReservationEntity r=reservation.addReservation(reserv);
        List<TicketEntity> tickets= (List<TicketEntity>) reserv.getTicketsReservation();
        for(TicketEntity ticket:tickets){
            ticket.setReservationByIdReservation(r);
            tick.addTicket(ticket);
        }
        return "redirect:/index";
    }
}
