package com.crudjpaHeranca.model.repository;
import com.crudjpaHeranca.model.entity.Horario;
import com.crudjpaHeranca.model.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HorarioRepository{
    @PersistenceContext
    EntityManager em;
    public List<Horario> findALLByIsFixed() {
        TypedQuery<Horario> query = em.createQuery(
                "SELECT h FROM Horario h WHERE h.fixed = true", Horario.class);
        return query.getResultList();
    }
    public Horario findByID(Long id){
        return em.find(Horario.class, id);
    }
    public void save(Horario horario){
        em.persist(horario);
    }
    public List<Horario> findHorariosByMedicoCrm(Long medicoId) {
        TypedQuery<Horario> query = em.createQuery(
                "SELECT h FROM Horario h WHERE h.medico.id = :medicoId", Horario.class);
        query.setParameter("medicoId", medicoId);
        return query.getResultList();
    }
}
