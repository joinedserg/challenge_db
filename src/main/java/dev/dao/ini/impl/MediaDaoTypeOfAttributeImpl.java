/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.dao.ini.impl;

import dev.dao.ini.MediaDaoTypeOfAttribute;
import dev.models.TypeOfAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Наталья
 */
@Repository
public class MediaDaoTypeOfAttributeImpl implements MediaDaoTypeOfAttribute {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void save(TypeOfAttribute type) {
        em.persist(type);
    }
    
    
}
