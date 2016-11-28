package dev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;


@Entity
@Table(name="entities")
//@SQLInsert(sql = "insert into entities(type_of_entity_id, parent_id, entity_id) values(?, ?, ?)")
public class RegEntity {
	
	@Id
	@GeneratedValue  //(strategy = GenerationType.IDENTITY)
	@Column(name = "entity_id", unique = true, nullable = false)
	private Integer id;

	private Integer type_of_entity_id;
	
	private Integer parent_id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType_of_entity_id() {
		return type_of_entity_id;
	}

	public void setType_of_entity_id(Integer type_of_entity_id) {
		this.type_of_entity_id = type_of_entity_id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
		
}
