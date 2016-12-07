package dev.ini;

import dev.models.*;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.*;
import dev.services.ini.*;

@EnableTransactionManagement
public class Initial {

    private static final Logger logger = Logger.getLogger(Initial.class);

    
    public static void main(String[] args) {
        System.out.println("G " + Initial.class.getSimpleName());

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        
        MediaServiceEntity serviceEntity = (MediaServiceEntity) context.getBean("storageServiceUser");
        BaseEntity entity = new BaseEntity("name1", "surname1");
        
        serviceEntity.save(entity);
        
        
        entity = new BaseEntity("name2", "surname2");
        serviceEntity.save(entity);
        
        entity.getAttributes().get(0).setValue("changed_value_attribute");
        serviceEntity.update(entity);
        //serviceEntity.delete(entity);
    }

}
