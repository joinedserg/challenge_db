package dev.models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
		{
			//@NamedQuery(name = "", query = ""),
			//@NamedQuery(name = "", query = ""),
			@NamedQuery(name = "insertUser", 
					query = "INSERT INTO entities(entity_id, type_of_entity) "
							+ "VALUES(:user_id, select "
							+ "type_of_entity_id "
							+ "FROM types_of_entities "
							+ "WHERE name = :class_name")
		}
		
)
//@Table(name="table_user")
public class User implements Commentable {

	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	private String name;
	private String surname;
	//private Date date;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/*public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	*/
}
