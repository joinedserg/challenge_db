package dev.ini;

import dev.models.*;
import dev.services.ini.MediaServiceTypeOfAttribute;
import dev.services.ini.MediaServiceTypeOfEntity;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
public class Runner {

    private static final Logger logger = Logger.getLogger(Runner.class);

    
    public static void main(String[] args) {
        System.out.println("G " + Runner.class.getSimpleName());

        InitialLoader.initial();
        
        
        /*MediaServiceEntity serviceEntity = (MediaServiceEntity) context.getBean("storageServiceUser");
        BaseEntity entity = new BaseEntity("name1", "surname1");
        
        serviceEntity.save(entity);
        
        
        //entity = new BaseEntity("name2", "surname2");
        //serviceEntity.save(entity);
        
        /*System.out.println("\n\ngetAll");
        List<BaseEntity> list = serviceEntity.getAll();
        for(BaseEntity b : list) {
        	System.out.println(b);
        	
        }*/
        

        //entity.getAttributes().get(0).setValue("changed_value_attribute");
        //serviceEntity.update(entity);*/

        //serviceEntity.delete(entity);
    }

}
