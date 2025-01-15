package org.restaurant.repository;

import org.restaurant.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("SELECT s FROM Agenda s WHERE s.day = :day AND s.isAvailable = true")
    List<Agenda> findAvailableAgendaByDay(@Param("day") String day);

    @Query("SELECT a FROM Agenda a")
    List<Agenda> findAllAgenda();
}
