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
import dev.models.RegEntity;
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
		RegEntity r = new RegEntity();
		//em.getTransaction().begin();
		
		//TransactionDefinition definition = new DefaultTransactionDefinition();
        //TransactionStatus status = transactionManager.getTransaction(definition);
		
		em.persist(r);
		
		
		//transactionManager.commit(status);
		
		/*em.flush();*/
		
		//em.getTransaction().commit();
		/*
		//@Inject
		JpaTransactionManager txManager;

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("rootTransaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		
		txManager.commit();*/
		
		int id = r.getId();
		user.setId(id);
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		String sql = "Insert into values(entity_id, attribute_id, text_value) values(:entity_id, 1, 'ff')";
		Query query = em.createNativeQuery(sql);
		
		
		query.setParameter("entity_id", id);
		int row = query.executeUpdate();
		System.out.println("Inserted ros: " + row);
		
	}
    
	public void save(User user) {
		em.persist(user);
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
