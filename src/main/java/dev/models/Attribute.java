package dev.models;

import javax.persistence.*;


@Entity
public class Attribute {
	
	
	public Attribute() {
	}
	
	public Attribute(Integer attribute_id, String value) {
		this.attribute_id = attribute_id;
		this.value = value;
	}
	
	@Id
	//@GeneratedValue
	@Column(name="attribute_id", nullable=false)
	private Integer attribute_id;
	
	@Column(name="text_value")
	private String value;
	
	//@ManyToOne
	//@Cascade(value=CascadeType.ALL)
	//@JoinColumn(name=entity)
	
	
	public Integer getAttribute_id() {
		return attribute_id;
	}
	
	
	public void setAttribute_id(Integer attribute_id) {
		this.attribute_id = attribute_id;
	}
	
	
	public String getValue() {
		return value;
	}
	
	
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
