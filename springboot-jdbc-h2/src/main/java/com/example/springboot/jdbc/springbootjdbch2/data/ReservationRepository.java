package com.example.springboot.jdbc.springbootjdbch2.data;


import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends
    JpaRepository<Reservation, Long> {
  Iterable<Reservation> findReservationByReservationDate(Date date);
}
