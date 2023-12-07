package com.crudjpaHeranca.model.repository;
import com.crudjpaHeranca.model.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
}
