package org.restaurant.repository;

import org.restaurant.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByDay(String day);

    @Query("SELECT r FROM Reservation r WHERE r.day = :day AND ( (r.startTime < :endTime AND r.endTime > :startTime))")
    List<Reservation> findOverlappingReservations(@Param("day") String day, @Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime);
}
