package dev.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="values")
@IdClass(AttributePK.class)
public class Attribute implements Serializable {


	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="attribute_id", insertable=true, updatable=false)
	private Integer attribute_id;
	
	@Id
	@Column(name="entity_id", insertable=true, updatable=false)
	private Integer entity_id;
	
	private String name;
	
	

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAttribute_id() {
		return attribute_id;
	}

	public void setAttribute_id(Integer attribute_id) {
		this.attribute_id = attribute_id;
	}


	
	public Integer getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(Integer entity_id) {
		this.entity_id = entity_id;
	}



	@Column(name = "text_value", updatable = true, insertable=true)
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
    	if (this == o) 
			return true;
		if (!(o instanceof AttributePK)) 
			return false;
		AttributePK targetId = (AttributePK) o;
		
		if (attribute_id != null ? !attribute_id.equals(targetId.getAttribute_id()) : targetId.getAttribute_id() != null)
			return false;
		if (entity_id != null ? !entity_id.equals(targetId.getEnitity_id()) : targetId.getEnitity_id() != null) 
			return false;
		

        return true;
    }

    @Override
    public int hashCode() {
    	int result = attribute_id != null ? attribute_id.hashCode() : 0;
		result = 31 * result + (entity_id != null ? entity_id.hashCode() : 0);
		
		return result;
    }
    
    public String toString() {
    	
    	return "entity_id: " + this.entity_id 
    			+ "  attribute_id: " + this.attribute_id 
    			+ "  value: " + this.value;
    }
    
}








