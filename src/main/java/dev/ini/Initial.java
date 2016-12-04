package dev.ini;

import dev.models.User;
import dev.services.ini.MediaServiceUser;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
public class Initial {
	
    private static final Logger logger = Logger.getLogger(Initial.class);
    
    
    public static void main(String[] args) {
    	System.out.println("G " + Initial.class.getSimpleName());
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		MediaServiceUser serviceUser = (MediaServiceUser) context.getBean("storageServiceUser");
		
		
		User user = new User("name1", "surname1");
		serviceUser.save(user);
		
		
		
    }
    

}

