package com.crudjpaHeranca.model.repository;

import com.crudjpaHeranca.model.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda,Long> {
}
