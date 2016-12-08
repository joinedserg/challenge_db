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
        attributes = new HashMap<String, Attribute>();
        
    }
    
    //TODO: Only 4 DEBUG!!!
    public BaseEntity(String name, String surname) {
        attributes = new HashMap<String, Attribute>();
        
        Attribute attr = new Attribute(); 
        attr.setValue(name);
        attr.setAttribute_id(1);
  
        attributes.put("name",  attr);
        
        
        attr = new Attribute();
        attr.setAttribute_id(2);
        attr.setValue(surname);
        attributes.put("surname", attr);
        
        this.id = 1;
        
        
    }
    
    
    
    
    @Id
    //@GeneratedValue
    @Column(name="entity_id", insertable=true, updatable=false)
    protected Integer id;
    
    
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER/*????*/)
    //@CollectionOfElements(fetch = FetchType.LAZY)
    //@MapKey(columns = @Column(name = "name"))
    //@MapKey(columns=@Column(name="name"))
    @javax.persistence.MapKey(name = "name")
    @JoinColumns({
    	@JoinColumn(name="entity_id", referencedColumnName="entity_id", 
    			insertable=true, updatable=true),
    	//@JoinColumn(name="")
    })
    protected Map<String, Attribute> attributes;
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
        
        for(Attribute attr : attributes.values()) {
        	attr.setEntity_id(id);
        }
    }
	
	
    
    /*public List<Attribute> getAttributes() {
        return new ArrayList<Attribute>(attributes.values());   
    }*/
    
    /*public void setAttributes(List<Attribute> attr) {
        //TODO: warnnnnnn!!!!!!!!!!!
    	//for()
    	System.out.println("\npublic void setAttributes(List<Attribute> attr)");
    	
    	if(this.attributes == null) {
    		this.attributes = new HashMap<String, Attribute>();
    	}
    	
    	for(String str : this.attributes.keySet()) {
    		System.out.println(str);
    	}
    	
    	if(attr.getClass().getSimpleName().equals("PersistentBag")) {
    		System.out.println("PersistentBag");
    		return;
    	}
    	
    	for(Attribute at : attr) {
    		System.out.println(at);
    		
    		if(at.getAttribute_id() == 1) {
    			if(attributes.get("name") == null) {
    				attributes.put("name", at);
    			}
    			else {
    				attributes.get("name").setValue(at.getValue());
    			}
    		}
    		else if(at.getAttribute_id() == 2) {
    			if(attributes.get("surname") == null) {
    				attributes.put("surname", at);
    			}
    			else {
    				attributes.get("surname").setValue(at.getValue());
    			}
    		}
    	}
    	
    	
    	
        
    }*/
    
    public Map<String, Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Attribute> attributes) {
		this.attributes = attributes;
	}

	public void setAttribute(String name, String value) {
        this.attributes.get(name).setValue(value);
    }
    
    public String getAttributeValue(String name) {
        return attributes.get(name).getValue();
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