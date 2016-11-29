package dev.dao.ini.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.models.ini.TypeOfAttribute;

public class MediaDaoTypeOfAttributeImpl {
    @PersistenceContext
    private EntityManager em;

    
    public void save(TypeOfAttribute type) {
        em.persist(type);
    }

    public List<TypeOfAttribute> getAll() {
        return em.createQuery("from TypeOfAttribute", TypeOfAttribute.class).getResultList();
    }
    
}
