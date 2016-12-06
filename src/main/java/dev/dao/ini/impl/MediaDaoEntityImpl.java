package dev.dao.ini.impl;

import java.util.List;

import javax.persistence.*;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import dev.models.BaseEntity;
import dev.dao.ini.MediaDaoEntity;

@Repository
public class MediaDaoEntityImpl implements MediaDaoEntity {

    @PersistenceContext
    private EntityManager em;

    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        //this.transactionManager = transactionManager;
    }

    public void save(BaseEntity entity) {
        em.persist(entity);
    }

    public List<BaseEntity> getAll() {
        List<BaseEntity> list = em.createNamedQuery("from BaseEntity", BaseEntity.class).getResultList();
        return list;
    }

    //@Override
    public void delete(BaseEntity entity) {
        em.remove(em.merge(entity));
    }

    //@Override
    public void update(BaseEntity entity) {
        em.merge(entity);
    }
   
}


