package dev.ini;
<<<<<<< HEAD
import dev.dao.ini.impl.MediaDaoUserImpl;
import dev.models.User;
import dev.models.ini.TypeOfAttribute;
import dev.models.ini.TypeOfEntity;
import dev.services.ini.MediaService;
=======
import dev.models.User;
import dev.models.simpleentity.Name;
import dev.models.simpleentity.Surname;
>>>>>>> 28dc78b846c939704e35d66847d4408b8557839e
import dev.services.ini.MediaServiceUser;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

<<<<<<< HEAD
import java.util.*;
=======
>>>>>>> 28dc78b846c939704e35d66847d4408b8557839e

@EnableTransactionManagement
public class Initial {
    private static final Logger logger = Logger.getLogger(Initial.class);
    
    
    public static void main(String[] args) {
    	System.out.println("G " + Initial.class.getSimpleName());
    	ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		
<<<<<<< HEAD
		MediaService service = (MediaService) context.getBean("storageService");
		TypeOfEntity e = Initial.getUserInfoType();		
		service.save(e);
		
		e = Initial.getChallengType();
		service.save(e);
		
		MediaServiceUser serviceUser = (MediaServiceUser) context.getBean("storageServiceUser");
		User user = new User("name1");
		
=======
		/*MediaService service = (MediaService) context.getBean("storageService");
		//TypeOfEntity e = Initial.getUserInfoType();		
		service.save(e);
		
		e = Initial.getChallengType();
		service.save(e);*/
		
		MediaServiceUser serviceUser = (MediaServiceUser) context.getBean("storageServiceUser");
		User user = new User();
                
                Name n = new Name("hhh");
                Surname s = new Surname("aaa");
                user.setSurname(s);
                //n.setAttribute_id(1);
                user.setName(n);
		n.setUser(user);
                s.setUser(user);
>>>>>>> 28dc78b846c939704e35d66847d4408b8557839e
		serviceUser.add(user);
		
		/*MediaDaoUserImpl daoUser = (MediaDaoUserImpl) context.getBean("devUserDaoImpl");
		
		User user = new User("name1");
		
		daoUser.add(user);*/
		
		//user = new User("name2");
		//serviceUser.add(user);
		
		//serviceUser.getAll();
		
		/*logger.info("Список всех type_of_entity:");
		for (TypeOfEntity type : service.getAll()) {
			logger.info(type);
		}*/
    }
    
<<<<<<< HEAD
    
    static TypeOfEntity getUserInfoType() {
    	TypeOfEntity t = new TypeOfEntity();
    	
    	t.setNameTypeEntity(User.class.getSimpleName());
=======
    /*
    static TypeOfEntity getUserInfoType() {
    	TypeOfEntity t = new TypeOfEntity();
    	
    	t.setNameTypeEntity(UserOld.class.getSimpleName());
>>>>>>> 28dc78b846c939704e35d66847d4408b8557839e
    	
    	List<TypeOfAttribute> list = new ArrayList<TypeOfAttribute>();
    	list.add(new TypeOfAttribute("name"));
    	list.add(new TypeOfAttribute("surname"));
    	list.add(new TypeOfAttribute("date"));
    	
    	
    	/*list.add(new TypeOfAttribute("birthday"));
    	list.add(new TypeOfAttribute("id_location"));
    	list.add(new TypeOfAttribute("date_registration"));
    	list.add(new TypeOfAttribute("count_success"));
    	list.add(new TypeOfAttribute("count_fail"));
    	list.add(new TypeOfAttribute("active"));
    	list.add(new TypeOfAttribute("ref_image"));*/
    	
<<<<<<< HEAD
    	t.setAttributes(list);
    	return t;
    }
    
    static TypeOfEntity getChallengType() {
=======
    	/*t.setAttributes(list);
    	return t;
    }*/
    
    /*static TypeOfEntity getChallengType() {
>>>>>>> 28dc78b846c939704e35d66847d4408b8557839e
    	TypeOfEntity t = new TypeOfEntity();
    	
    	t.setNameTypeEntity("challenge");
    	
    	List<TypeOfAttribute> list = new ArrayList<TypeOfAttribute>();
    	
    	list.add(new TypeOfAttribute("fio"));
    	/*list.add(new TypeOfAttribute("id")); //???
    	list.add(new TypeOfAttribute("header"));
    	list.add(new TypeOfAttribute("description"));
    	
    	list.add(new TypeOfAttribute("id_performing"));
    	list.add(new TypeOfAttribute("id_calling"));
    	list.add(new TypeOfAttribute("id_location"));
    	list.add(new TypeOfAttribute("startpos"));
    	list.add(new TypeOfAttribute("finalpos"));
    	list.add(new TypeOfAttribute("date_start"));
    	list.add(new TypeOfAttribute("date_stop"));
    	list.add(new TypeOfAttribute("report"));
    	list.add(new TypeOfAttribute("status"));*/
    	    	
<<<<<<< HEAD
    	t.setAttributes(list);    	    	
    	return t;
    }
    
=======
    	/*t.setAttributes(list);    	    	
    	return t;
    }
    */
>>>>>>> 28dc78b846c939704e35d66847d4408b8557839e
}

