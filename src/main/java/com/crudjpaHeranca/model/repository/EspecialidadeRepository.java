package com.crudjpaHeranca.model.repository;

import com.crudjpaHeranca.model.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository  extends JpaRepository<Especialidade,Long> { }
