package com.crudjpaHeranca.model.repository;

import com.crudjpaHeranca.model.entity.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Paciente> pacientes(){
        Query query = em.createQuery("from Paciente");
        return query.getResultList();
    }

    public Paciente paciente(Long id){
        return em.find(Paciente.class, id);
    }

    public void save(Paciente paciente){ em.persist(paciente); }

    public void update(Paciente paciente){
        em.merge(paciente);
    }

    public void delete(Long id){
        Paciente paciente = em.find(Paciente.class, id);
        em.remove(paciente);
    }
}
