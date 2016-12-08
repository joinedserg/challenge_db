package dev.ini;

import dev.models.TypeOfAttribute;
import dev.models.TypeOfEntity;
import dev.services.ini.MediaServiceTypeOfAttribute;
import dev.services.ini.MediaServiceTypeOfEntity;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitialLoader {
    
    public static void initial() {
        //try load from base
        
        //else 
        //create
        createContext();
        
        
        //return null;
    }
    
    private static void createContext() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        
        TypeOfAttribute attrName = new TypeOfAttribute(1, "name", 1);
        TypeOfAttribute attrSurname = new TypeOfAttribute(2, "surname", 1);
        TypeOfAttribute attrDate = new TypeOfAttribute(3, "date", 2);
        
        MediaServiceTypeOfAttribute serviceAttr = (MediaServiceTypeOfAttribute) context.getBean("storageServiceTypeOfAttribute");
        
        serviceAttr.save(attrName);        
        serviceAttr.save(attrSurname);        
        serviceAttr.save(attrDate);        
        
                
        MediaServiceTypeOfEntity serviceEntity = (MediaServiceTypeOfEntity)context.getBean("storageServiceTypeOfEntity");
        
        TypeOfEntity entity = new TypeOfEntity("User");
        entity.add(attrName);
        entity.add(attrSurname);
        serviceEntity.save(entity);
        
        TypeOfEntity entityChallenge = new TypeOfEntity("ChallengeRoadMap");
        entityChallenge.add(attrName);
        entityChallenge.add(attrDate);
        serviceEntity.save(entityChallenge);
        
        
        ContextType contextType = ContextType.getInstance();
        
        contextType.add(attrName);
        contextType.add(attrSurname);
        contextType.add(attrDate);
        
        contextType.add(entity);
        contextType.add(entityChallenge);        
    }
    
}
