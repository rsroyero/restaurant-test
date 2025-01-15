package org.restaurant.service;

import org.restaurant.dto.ReservationDTO;
import org.restaurant.entity.Agenda;
import org.restaurant.entity.Reservation;
import org.restaurant.exception.ScheduleOverlapException;
import org.restaurant.repository.ReservationRepository;
import org.restaurant.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AgendaRepository agendaRepository;

    public Reservation createReservation(ReservationDTO dto) {
        Agenda agenda = agendaRepository.findById((long) dto.getIdAgenda())
                .orElseThrow(() -> new RuntimeException("Agenda not found"));

        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
                dto.getDay(),
                dto.getStartTime(),
                dto.getEndTime()
        );

        if (!overlappingReservations.isEmpty()) {
            throw new ScheduleOverlapException("The schedule overlaps with an existing reservation.");
        }

        Reservation reservation = new Reservation();
        reservation.setFirstName(dto.getFirstName());
        reservation.setLastName(dto.getLastName());
        reservation.setNumPeople(dto.getNumPeople());
        reservation.setDay(dto.getDay());
        reservation.setStartTime(dto.getStartTime());
        reservation.setEndTime(dto.getEndTime());
        reservation.setAgenda(agenda);

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByDay(String day) {
        return reservationRepository.findByDay(day);
    }

    public Reservation updateReservation(Long id, ReservationDTO dto) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        Agenda agenda = agendaRepository.findById((long) dto.getIdAgenda())
                .orElseThrow(() -> new RuntimeException("Agenda not found"));

        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
                dto.getDay(),
                dto.getStartTime(),
                dto.getEndTime()
        );

        List<Reservation> filteredReservations = new ArrayList<>();
        for (Reservation r : overlappingReservations) {
            if (!r.getId().equals(id)) {
                filteredReservations.add(r);
            }
        }

        if (!filteredReservations.isEmpty()) {
            throw new ScheduleOverlapException("The schedule overlaps with an existing reservation.");
        }

        reservation.setFirstName(dto.getFirstName());
        reservation.setLastName(dto.getLastName());
        reservation.setNumPeople(dto.getNumPeople());
        reservation.setDay(dto.getDay());
        reservation.setStartTime(dto.getStartTime());
        reservation.setEndTime(dto.getEndTime());
        reservation.setAgenda(agenda);

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
