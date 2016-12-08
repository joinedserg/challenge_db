package dev.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;


//add
//update
//remove
//select 


@Entity
@Table(name="entities")
public class BaseEntity {
    public BaseEntity() {
        attributes = new HashMap<Integer, Attribute>();
        
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
    protected Integer id;
    
    
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER/*????*/)
    @MapKey(name = "attribute_id")
    @JoinColumns({
    	@JoinColumn(name="entity_id", referencedColumnName="entity_id", 
    			insertable=false, updatable=false),
    })
    /*ID attribute, Attribute value*/
    protected Map<Integer, Attribute> attributes;
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
        
        for(Attribute attr : attributes.values()) {
        	attr.setEntity_id(id);
        }
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