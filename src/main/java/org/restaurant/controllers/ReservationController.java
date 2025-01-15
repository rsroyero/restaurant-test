package org.restaurant.controllers;

import org.restaurant.dto.ReservationDTO;
import org.restaurant.entity.Reservation;
import org.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO dto) {
        return ResponseEntity.ok(reservationService.createReservation(dto));
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<Reservation>> getReservationsByDate(@RequestParam String day) {
        return ResponseEntity.ok(reservationService.getReservationsByDay(day));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO dto) {
        return ResponseEntity.ok(reservationService.updateReservation(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
