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
        /*Example entity*/
        User user1 = new User();
        serviceEntity.save(user1);
        
        User user2 = new User();
        user2.setName("name2");
        serviceEntity.save(user2);
        
        User user3 = new User();
        user3.setName("name3");
        serviceEntity.save(user3);
        
        User user4 = new User();
        user4.setName("name4");
        serviceEntity.save(user4);
        
        System.out.println("\n\nUpdate");
        user1.setName("new_name");
        //user1.setParent(user2);
        serviceEntity.update(user1);
        
        user4.setName("new_name4");
        //user4.setParent(user2);
        serviceEntity.update(user4);
        
        Set userSet = new HashSet();
        userSet.add(user1);
        userSet.add(user4);
        user2.setChildren(userSet);
        serviceEntity.update(user2);


        /*change mechanism and add template*/
//        User entityUser2 = (User)serviceEntity.findById(user1.getId());
//        Integer count = entityUser2.getChildren().size();
        /**/
        
        System.out.println("\n\nDelete");
        serviceEntity.delete(user1);
        
        System.out.println("\n\nGet all");
        /**
         * *TEMPLAAAAAAAAAAAAAAAAAAAAAAATE !!!!!!***
         */
        List<User> list = serviceEntity.getAll(User.class);
        for (User b : list) {
            System.out.println(b);
        }
        
        System.out.println("\n\nDelete");
        serviceEntity.delete(user2);
        
        System.out.println("\n\nGet all");
        /**
         * *TEMPLAAAAAAAAAAAAAAAAAAAAAAATE !!!!!!***
         */
        list = serviceEntity.getAll(User.class);
        for (BaseEntity b : list) {
            System.out.println(b);
        }
                
        User user6 = new User();
        user6.setName("name6");
        serviceEntity.save(user6);
        ChallengeRoadMap m = new ChallengeRoadMap();
        serviceEntity.save(m);      
        user3.addChallenge(m);        
        user3.addFriend(user6);
        serviceEntity.update(user3);
        
        System.out.println("modified users: \n");
        System.out.println(user3.toString());
        System.out.println(user6.toString());
        
        ChallengeRoadMap challengeRoadMap1 = new ChallengeRoadMap();        
        challengeRoadMap1.setName("challengeName1");        
        serviceEntity.save(challengeRoadMap1);

        /**
         * *TEMPLAAAAAAAAAAAAAAAAAAAAAAATE !!!!!!***
         */
        list = serviceEntity.getAll(User.class);
        
        for (User b : list) {
            System.out.println(b);
        }

        /*BaseEntity entity = new BaseEntity("name1", "surname1");

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
        }*/
    }
    
}
