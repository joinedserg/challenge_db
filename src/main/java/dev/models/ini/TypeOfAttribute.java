package dev.models.ini;

import javax.persistence.*;
import java.util.*;

//@Entity
//@Table(name="attributes")
public class TypeOfAttribute {
	
	@Id 
	@GeneratedValue
	@Column(name="attribute_id")
	private long id;
	

	private long type_of_attribute;
	
	@Column(name="name"/*, unique = true*/)
	private String name;

	@ManyToMany(mappedBy = "listAttributes") 
	private List<TypeOfEntity> typeEntities;
	
	public TypeOfAttribute() {
		
	}
	
	public TypeOfAttribute(String name) {
		this.name = name;
	}
	
	public long getType_of_attribute() {
		return type_of_attribute;
	}

	public void setType_of_attribute(long type_of_attribute) {
		this.type_of_attribute = type_of_attribute;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<TypeOfEntity> getTypeEntities() {
		return typeEntities;
	}

	public void setTypeEntities(List<TypeOfEntity> typeEntities) {
		this.typeEntities = typeEntities;
	}

	public String toString() {
		return "\n    ID_TypeOfAttribute: " + id + "  Name: " + name + "  ";
	}
}
