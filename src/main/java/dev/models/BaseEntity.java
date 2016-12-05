package dev.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


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
        attributes.put("name",  new Attribute(0, name));
        attributes.put("surname", new Attribute(1, surname));
        
    }
    
    protected Integer id;
    protected Map<String, Attribute> attributes;
    
    @Id
    @GeneratedValue
    @Column(name="entity_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @OneToMany(mappedBy="entity", fetch=FetchType.EAGER,
			cascade = CascadeType.ALL)
    //@JoinColumn(name="entity_id")
    public List<Attribute> getAttributes() {
        return new ArrayList<Attribute>(attributes.values());   
    }
    
    public void setAttributes(List<Attribute> attr) {
        //TODO: warnnnnnn!!!!!!!!!!!
        System.out.println("public void setAttributes(List<Attribute> attr)");
    }
    
    public void setAttribute(String name, String value) {
        this.attributes.get(name).setValue(value);
    }
    
    public String getAttributeValue(String name) {
        return attributes.get(name).getValue();
    }
    
}
