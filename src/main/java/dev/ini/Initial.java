package dev.ini;

import dev.models.User;
import dev.models.BaseEntity;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import dev.services.ini.MediaServiceEntity;

@EnableTransactionManagement
public class Initial {

    private static final Logger logger = Logger.getLogger(Initial.class);

    public static void main(String[] args) {
        System.out.println("G " + Initial.class.getSimpleName());

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        MediaServiceEntity serviceUser = (MediaServiceEntity) context.getBean("storageServiceUser");

        BaseEntity entity = new BaseEntity("name1", "surname1");
        serviceUser.save(entity);

        /*entity = new BaseEntity("name2", "surname2");
        serviceUser.save(entity);
        */
        entity.setAttribute("name", "changed name");
        serviceUser.update(entity);
        
        
    }

}
