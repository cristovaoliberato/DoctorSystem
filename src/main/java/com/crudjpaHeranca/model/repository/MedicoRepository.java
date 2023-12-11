package com.crudjpaHeranca.model.repository;

import com.crudjpaHeranca.model.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Medico> medicos(){
        Query query = em.createQuery("from Medico");
        return query.getResultList();
    }

    public Medico medicoid(Long id){
        return em.find(Medico.class, id);
    }
    public void save(Medico medico){
        em.persist(medico);
    }

    public void update(Medico medico){
        em.merge(medico);
    }

    public void delete(String crm) {
        TypedQuery<Medico> query = em.createQuery("SELECT m FROM Medico m WHERE m.crm = :crm", Medico.class);
        query.setParameter("crm", crm);
        Medico medico = query.getSingleResult();

        if (medico != null) {
            em.remove(medico);
        }
    }

    public Medico medico(String crm){
        TypedQuery<Medico> query = em.createQuery(
                "SELECT m FROM Medico m WHERE m.crm = :crm", Medico.class);
        query.setParameter("crm", crm);
        return query.getSingleResult();
    }
}
