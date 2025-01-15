package org.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private String firstName;
    private String lastName;
    private int numPeople;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
}
