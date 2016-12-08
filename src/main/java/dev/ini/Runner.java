package dev.ini;

import dev.models.*;
import dev.services.ini.MediaServiceEntity;
import dev.services.ini.MediaServiceTypeOfAttribute;
import dev.services.ini.MediaServiceTypeOfEntity;

import java.util.HashMap;
import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableTransactionManagement
public class Runner {

    private static final Logger logger = Logger.getLogger(Runner.class);

    
    public static void main(String[] args) {
        System.out.println("G " + Runner.class.getSimpleName());

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        
        InitialLoader.initial(context);
        
        
        MediaServiceEntity serviceEntity = (MediaServiceEntity) context.getBean("storageServiceUser");
        BaseEntity entity = new BaseEntity("name1", "surname1");
        
        serviceEntity.save(entity);
        
        BaseEntity entity2 = new BaseEntity("name2", "surname2");
        serviceEntity.save(entity2);
        
        
        BaseEntity entity3 = new BaseEntity("name3", "surname3");
        serviceEntity.save(entity3);
        
        
        
        System.out.println("\n\nGet all");
        List<BaseEntity> list = serviceEntity.getAll();
        for(BaseEntity b : list) {
        	System.out.println(b);
        }
        
        
        entity2.getAttributes().get(1).setValue("changed_name2");
        serviceEntity.update(entity2);
        
        System.out.println("\n\nGet all");
        list = serviceEntity.getAll();
        for(BaseEntity b : list) {
        	System.out.println(b);
        }
        
        System.out.println("\n\nDelete");
        
        //serviceEntity.update(entity3);
        serviceEntity.delete(entity3);
        
        
        System.out.println("\n\nGet all");
        list = serviceEntity.getAll();
        for(BaseEntity b : list) {
        	System.out.println(b);
        }
    }

}
