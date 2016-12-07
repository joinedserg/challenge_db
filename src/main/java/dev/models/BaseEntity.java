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
    
    protected Integer id;
    protected Map<String, Attribute> attributes;
    
    @Id
    //@GeneratedValue
    @Column(name="entity_id")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
        for(Attribute attr : attributes.values()) {
        	attr.setEntity_id(id);
        }
    }
	
	
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY/*????*/)
    @JoinColumns({
    	@JoinColumn(name="entity_id", referencedColumnName="entity_id")
    })
    public List<Attribute> getAttributes() {
        return new ArrayList<Attribute>(attributes.values());   
    }
    
    public void setAttributes(List<Attribute> attr) {
        //TODO: warnnnnnn!!!!!!!!!!!
    	//for()
    	//for(Attribute at : attr) {
    		/*if(at.getAttribute_id() == 1) {
    			attributes.get("name").setEntity_id(at.getEntity_id());
    			attributes.get("name").setValue(at.getValue());
    		}
    		else {
    			attributes.get("surname").setEntity_id(at.getEntity_id());
    			attributes.get("surname").setValue(at.getValue());
    		}*/
    	//}
    	
        System.out.println("public void setAttributes(List<Attribute> attr)");
    }
    
    public void setAttribute(String name, String value) {
        this.attributes.get(name).setValue(value);
    }
    
    public String getAttributeValue(String name) {
        return attributes.get(name).getValue();
    }
    
}