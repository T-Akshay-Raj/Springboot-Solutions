package com.example.springboot.jdbc.springbootjdbch2.restcontroller;

import com.example.springboot.jdbc.springbootjdbch2.data.Guest;
import com.example.springboot.jdbc.springbootjdbch2.data.Room;
import com.example.springboot.jdbc.springbootjdbch2.service.ReservationService;
import com.example.springboot.jdbc.springbootjdbch2.service.RoomReservation;
import com.example.springboot.jdbc.springbootjdbch2.util.DateUtils;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebRestController {
  private final DateUtils dateUtils;
  private final ReservationService reservationService;

  public WebRestController(DateUtils dateUtils,
                           ReservationService reservationService) {
    this.dateUtils = dateUtils;
    this.reservationService = reservationService;
  }

  //GET http://localhost:8080/api/reservations
  @GetMapping("/reservations")
  public List<RoomReservation> getReservations(
      @RequestParam(value = "date", required = false) String dateString) {
    Date date = this.dateUtils.createDateFromDateString(dateString);
    return this.reservationService.getRoomReservationsForDate(date);
  }

  //GET http://localhost:8080/api/guests
  @GetMapping("/guests")
  public List<Guest> getGuests(Model model) {
    return this.reservationService.getHotelGuests();
  }

  //POST http://localhost:8080/api/guests
  @PostMapping("/guests")
  @ResponseStatus(HttpStatus.CREATED)
  public void addGuest(@RequestBody Guest guest) {
    this.reservationService.addGuest(guest);
  }

  //GET http://localhost:8080/api/rooms
  @GetMapping("/rooms")
  public List<Room> getRooms() {
    return this.reservationService.getRooms();
  }

}
