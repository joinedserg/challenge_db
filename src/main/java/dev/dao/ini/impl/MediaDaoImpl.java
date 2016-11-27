package dev.dao.ini.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dev.dao.ini.MediaDao;
import dev.models.ini.TypeOfEntity;

@Repository
public class MediaDaoImpl implements MediaDao {

    @PersistenceContext
    private EntityManager em;

    
    public void save(TypeOfEntity type) {
        em.persist(type);
    }

    public List<TypeOfEntity> getAll() {
        return em.createQuery("from TypeOfEntity", TypeOfEntity.class).getResultList();
    }
    
    
}
