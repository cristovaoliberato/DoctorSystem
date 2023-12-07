package com.crudjpaHeranca.model.repository;

import com.crudjpaHeranca.model.entity.Consulta;
import com.crudjpaHeranca.model.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Consulta> consultas(){
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }
    public void save(Consulta consulta){
        em.persist(consulta);
    }
    public void delete(Long consultaId) {
        Consulta consulta = em.find(Consulta.class, consultaId);
        if (consulta != null) {
            em.remove(consulta);
        }
    }
    public Consulta consultaid(Long id){
        return em.find(Consulta.class, id);
    }
    public void update(Consulta c){
        em.merge(c);
    }
}
