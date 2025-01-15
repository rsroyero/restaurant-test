package org.restaurant.controllers;

import org.restaurant.entity.Agenda;
import org.restaurant.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private AgendaService scheduleService;

    @GetMapping("/available")
    public ResponseEntity<List<Agenda>> getAvailableSchedules(@RequestParam String day) {
        return ResponseEntity.ok(scheduleService.getAvailableSchedulesByDay(day));
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }
}
