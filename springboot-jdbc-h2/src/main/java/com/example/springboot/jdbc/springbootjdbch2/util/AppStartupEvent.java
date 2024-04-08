package com.example.springboot.jdbc.springbootjdbch2.util;

import com.example.springboot.jdbc.springbootjdbch2.data.Guest;
import com.example.springboot.jdbc.springbootjdbch2.data.GuestRepository;
import com.example.springboot.jdbc.springbootjdbch2.data.Reservation;
import com.example.springboot.jdbc.springbootjdbch2.data.ReservationRepository;
import com.example.springboot.jdbc.springbootjdbch2.data.Room;
import com.example.springboot.jdbc.springbootjdbch2.data.RoomRepository;
import com.example.springboot.jdbc.springbootjdbch2.service.ReservationService;
import com.example.springboot.jdbc.springbootjdbch2.service.RoomReservation;
import java.util.Date;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent
    implements ApplicationListener<ApplicationReadyEvent> {
  private final ReservationService reservationService;
  private final DateUtils dateUtils;
  private final RoomRepository roomRepository;
  private final GuestRepository guestRepository;
  private final ReservationRepository reservationRepository;

  public AppStartupEvent(
      ReservationService reservationService,
      DateUtils dateUtils,
      RoomRepository roomRepository,
      GuestRepository guestRepository,
      ReservationRepository reservationRepository) {
    this.reservationService = reservationService;
    this.dateUtils = dateUtils;
    this.roomRepository = roomRepository;
    this.guestRepository = guestRepository;
    this.reservationRepository = reservationRepository;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    Iterable<Room> rooms = this.roomRepository.findAll();
    rooms.forEach(System.out::println);
    List<Guest> guests = this.guestRepository.findAll();
    guests.forEach(System.out::println);
    Iterable<Reservation> reservations = this.reservationRepository.findAll();
    reservations.forEach(System.out::println);


    long millis = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(millis);
    System.out.println(date);
    Iterable<Reservation> reservationByDate =
        this.reservationRepository.findReservationByReservationDate(date);


    Date date1 = this.dateUtils.createDateFromDateString("2022-01-01");
    List<RoomReservation> reservations1 =
        this.reservationService.getRoomReservationsForDate(date);
    reservations1.forEach(System.out::println);
  }
}

