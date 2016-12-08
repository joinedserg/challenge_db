package dev.dao.ini.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import dev.dao.ini.MediaDaoTypeOfEntity;
import dev.models.TypeOfEntity;

@Repository
public class MediaDaoTypeOfEntityImpl implements MediaDaoTypeOfEntity {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void save(TypeOfEntity typeOfEntity) {
        em.persist(typeOfEntity);
    }
    
}
