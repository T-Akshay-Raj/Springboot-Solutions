package com.example.springboot.jdbc.springbootjdbc.postgres.controller;

import com.example.springboot.jdbc.springbootjdbc.postgres.service.ReservationService;
import com.example.springboot.jdbc.springbootjdbc.postgres.service.RoomReservation;
import com.example.springboot.jdbc.springbootjdbc.postgres.util.DateUtils;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

  private final DateUtils dateUtils;
  private final ReservationService reservationService;

  public RoomReservationController(DateUtils dateUtils,
                                   ReservationService reservationService) {
    this.dateUtils = dateUtils;
    this.reservationService = reservationService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<RoomReservation> getReservations(
      @RequestParam(value = "date", required = false) String dateString,
      Model model) {
    Date date = this.dateUtils.createDateFromDateString(dateString);
    List<RoomReservation> roomReservations =
        this.reservationService.getRoomReservationsForDate(date);
    return roomReservations;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String getReservationsView(
      @RequestParam(value = "date", required = false) String dateString,
      Model model) {
    Date date = this.dateUtils.createDateFromDateString(dateString);
    List<RoomReservation> roomReservations =
        this.reservationService.getRoomReservationsForDate(date);
    model.addAttribute("roomReservations", roomReservations);
    return "roomres";
  }
}

