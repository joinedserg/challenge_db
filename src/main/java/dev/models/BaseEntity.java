package dev.models;


import java.util.*;

import javax.persistence.*;

import dev.ini.*;

import dev.models.ini.*;

//add
//update
//remove
//select 


//@Entity
//@Table(name="entities")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="published")
//@DiscriminatorValue(value="false")
@MappedSuperclass
public class BaseEntity {
	
    public BaseEntity() {
        attributes = new HashMap<Integer, Attribute>();
        
    }
    
    //call only from children 
    public BaseEntity(String entityName) {
    	TypeOfEntity type = ContextType.getInstance().getTypeEntity(entityName);
    	entityType = type.getTypeEntityID();
    	
    	attributes = new HashMap<Integer, Attribute>();
    	for(TypeOfAttribute t : type.getAttributes()) {
    		Attribute attr = new Attribute(t.getId());
    		
    		attributes.put(t.getId(), attr);	
    	}
    }
    
    //TODO: Only 4 DEBUG!!!
    public BaseEntity(String name, String surname) {
        //this.setId(1);
    	
    	attributes = new HashMap<Integer, Attribute>();
        
        Attribute attr = new Attribute();
        attr.setValue(name);
        //attr.setEntity_id(1);
        attr.setAttribute_id(1);
        this.attributes.put(1, attr);
        
        attr = new Attribute();
        attr.setValue(surname);
        //attr.setEntity_id(1);
        attr.setAttribute_id(2);
        
        this.attributes.put(2, attr);
    }
    
    
    @Id
    //@GeneratedValue
    @Column(name="entity_id", insertable=true, updatable=false)
    private Integer id;
        
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER/*????*/)
    @MapKey(name = "attribute_id")
    @JoinColumns({
    	@JoinColumn(name="entity_id", referencedColumnName="entity_id", 
    			insertable=false, updatable=false),
    })
    
    /*ID attribute, Attribute value*/
    private Map<Integer, Attribute> attributes;
    
    @Column(name="type_of_entity")
    private Integer entityType;
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
        
        for(Attribute attr : attributes.values()) {
        	attr.setEntity_id(id);
        }
    }
	
    
    public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public Map<Integer, Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<Integer, Attribute> attributes) {
		this.attributes = attributes;
	}
	

	
    public String toString() {
    	String str = "";
    	str = "id: " + this.id;
    	for(Attribute attr : this.attributes.values()) {
    		str += "\n" + attr;
    		
    	}
    	return str;
    }
    
}