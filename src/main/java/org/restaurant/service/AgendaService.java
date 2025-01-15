package org.restaurant.service;

import org.restaurant.entity.Agenda;
import org.restaurant.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository scheduleRepository;

    public List<Agenda> getAvailableSchedulesByDay(String day) {
        List<Agenda> schedules = scheduleRepository.findAvailableAgendaByDay(day);
        if (schedules.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No available schedules for the day: " + day);
        }
        return schedules;
    }

    public List<Agenda> getAllSchedules() {
        List<Agenda> schedules = scheduleRepository.findAllAgenda();
        System.out.println("Schedules: " + schedules);
        return schedules;
    }
}
