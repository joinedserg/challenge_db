package dev.models;


import java.util.*;


import dev.models.simpleentity.*;

import javax.persistence.*;


@Entity
@Table(name = "entities")
public class User {
    
    public User() {
    	//this.attributes = new HashMap<String, Attribute>();
    }
    
	public User(String name, String surname) {
		
		attribute = new ArrayList<Attribute>();
		
		attribute.add(new Attribute(0, name));
		attribute.add(new Attribute(1, surname));
		
		
		//this.attributes = new HashMap<String, Attribute>();
    	
    	//attributes.put("name", new Attribute(0, name));
    	//attributes.put("surname", new Attribute(1, surname));
		
    }
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entity_id")    
    private Integer entity_id;
    //private Map<String, Attribute> attributes;
    
	
	@OneToMany(fetch=FetchType.EAGER,
			cascade = CascadeType.ALL)
	@JoinColumn(name="entity_id")
	List<Attribute> attribute;
    
    
    public Integer getEntity_id() {
		return entity_id;
	}
 
	public void setEntity_id(Integer entity_id) {
		this.entity_id = entity_id;
	}
    
	public List<Attribute> getAttr() {
		//return new ArrayList(attributes.values());
		return attribute;
		//return null;
	}
	
	public void setAttr(List<Attribute> list) {
		//??
		this.attribute = list;
		System.out.println("setAttr");
		
	}

}

