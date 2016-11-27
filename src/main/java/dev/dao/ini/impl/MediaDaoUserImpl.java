package dev.dao.ini.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dev.dao.ini.MediaDaoUser;
import dev.models.User;
import dev.models.ini.TypeOfAttribute;

@Repository
public class MediaDaoUserImpl implements MediaDaoUser {

    @PersistenceContext
    private EntityManager em;
    
	public void add(User user) {
		em.persist(user);
		
		
		
	}
    
	public void save(User entity) {
		em.persist(entity);
	}
	
	
    public List<User> getAll() {
    	return null; //em.createQuery("from TypeOfAttribute", User.class).getResultList();
    }



    
	
    /*public void save(TypeOfAttribute type) {
        em.persist(type);
    }

    public List<TypeOfAttribute> getAll() {
        return em.createQuery("from TypeOfAttribute", TypeOfAttribute.class).getResultList();
    }*/

	
}
