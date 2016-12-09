package dev.models;

import java.util.*;

import javax.persistence.*;

import dev.models.BaseEntity;
import dev.models.ini.TypeOfAttribute;
import dev.ini.ContextType;

@Entity
@Table(name="entities")
@DiscriminatorValue("GenericClient")

public class User extends BaseEntity{

	public User() {
		super(User.class.getSimpleName());
		
		listChallengeRoadMap = new ArrayList<ChallengeRoadMap>();
	}
	
    @ManyToMany(fetch = FetchType.EAGER/*, cascade = {CascadeType.ALL}*/)
    @JoinTable(name = "relationship"//,
            //joinColumns = @JoinColumn(name = "entity_id"),
            //inverseJoinColumns = @JoinColumn(name = "entity_id2")/*,
            /*uniqueConstraints = @UniqueConstraint(columnNames = {"type_of_entity_id", "attribute_id"})*/)
    private List<ChallengeRoadMap> listChallengeRoadMap;
    
	public String getName() {
		return this.getAttributes()
			.get(ContextType.getInstance().getTypeAttribute("name").getId()).getValue();
	}
	
	public void setName(String name) {
		this.getAttributes()
			.get(ContextType.getInstance().getTypeAttribute("name").getId()).setValue(name);
	}
	
	
	
}
