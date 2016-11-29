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

import dev.dao.ini.MediaDaoUser;
import dev.models.User;
import dev.models.ini.TypeOfAttribute;

@Repository
public class MediaDaoUserImpl implements MediaDaoUser {

    @PersistenceContext
    private EntityManager em;
    
    private PlatformTransactionManager transactionManager;
    
    
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
	public void add(User user) {
		
		
                em.persist(user);
		
		
	}
    
	public void save(User user) {
		//em.persist(user);
	}
	
	
    public List<User> getAll() {
    	//List<User> list = em.createNamedQuery("getAllUser", User.class).getResultList();
    	//return list;
    	return null;    	
    }



    
	
    /*public void save(TypeOfAttribute type) {
        em.persist(type);
    }

    public List<TypeOfAttribute> getAll() {
        return em.createQuery("from TypeOfAttribute", TypeOfAttribute.class).getResultList();
    }*/

	
}
