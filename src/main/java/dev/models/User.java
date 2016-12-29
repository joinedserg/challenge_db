package dev.models;

import java.util.*;

import javax.persistence.*;

import dev.ini.ContextType;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "entities")
//@SecondaryTable(name="relationship2")
//@DiscriminatorValue(value="User")
public class User extends BaseEntity {

    public User() {
        super(User.class.getSimpleName());

        listChallengeRoadMap = new ArrayList<ChallengeRoadMap>();
        friends = new ArrayList<User>();
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    /*@JoinTable(name = "relationship2",
            joinColumns = @JoinColumn(name = "entity_id1", referencedColumnName = "entity_id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id2", referencedColumnName = "entity_id")
    )*/
    @JoinColumnsOrFormulas(value={
        @JoinColumnOrFormula(column=
                @JoinColumn(table="relationship2", name = "entity_id1", referencedColumnName="entity_id")),
        @JoinColumnOrFormula(column=
                @JoinColumn(table="relationship2", name = "entity_id2", referencedColumnName="entity_id")),
                        
        
        @JoinColumnOrFormula(formula=
                @JoinFormula(referencedColumnName="attribute_id", value="'kkkkk'"))
        
    })
    /**/
    @Where(clause="type_of_entity = 2")
    private List<ChallengeRoadMap> listChallengeRoadMap;

    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="relationship",
            joinColumns = @JoinColumn(name = "entity_id1", referencedColumnName = "entity_id"),            
            inverseJoinColumns = @JoinColumn(name = "entity_id2", referencedColumnName = "entity_id")
    )
    @Where(clause="type_of_entity = 1")
    private List<User> friends;  
    public void addFriend(User user) {
        friends.add(user);
    }
    
    public String getName() {
        return this.getAttributes()
                .get(ContextType.getInstance().getTypeAttribute("name").getId()).getValue();
    }

    public void setName(String name) {
        this.getAttributes()
                .get(ContextType.getInstance().getTypeAttribute("name").getId()).setValue(name);
    }

    public void addChallenge(ChallengeRoadMap m) {
        listChallengeRoadMap.add(m);
    }
    
    
    
    @Override
    public String toString() {
        String entityInfo = super.toString();
        StringBuilder info = new StringBuilder();
        info.append(entityInfo);
        info.append("\nFriends: \n");
        for(User u : friends) {
            info.append("\nid: " + u.getId() + " name:" + u.getName());
        }
        info.append("\nChallenges: \n");
        for(ChallengeRoadMap c : listChallengeRoadMap) {
            info.append("\nid: " + c.getId() + " name: " + c.getName());
        }
        return info.toString();
    } 
}
