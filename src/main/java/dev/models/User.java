<<<<<<< HEAD
package dev.models;

import java.util.*;

import javax.persistence.*;

//import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;


/*The value for annotation attribute NamedQuery.query must be a constant expression

INSERT INTO entities(entity_id, type_of_entity_id) 
VALUES( 0, ( select 
type_of_entity_id 
FROM types_of_entities 
WHERE types_of_entities.name = 'User')); 
 */

/*

INSERT INTO values(entity_id, attribute_id, text_value)
VALUES(
0,
(SELECT  
attributes.attribute_id 
FROM types_of_entities 
LEFT OUTER JOIN entity_attributes 
	ON types_of_entities.type_of_entity_id = entity_attributes.type_of_entity_id 
LEFT OUTER JOIN attributes 
	ON attributes.attribute_id = entity_attributes.attribute_id 
WHERE attributes.name = 'name' AND types_of_entities.name = 'User'),
'test');
  
 * */
//@NamedQueries({
/*sqlname = insertUser
		user_id
	*/
/*sqlname = queryInsertAttribute
	type_inserting_value - text_value | date_time_value | numeric_value 
	user_id			  	 - id inserted user
	inserting_value 	 - inserting value		 	 
*/


/*@NamedQuery(name = "queryInsertAttribute",
		query = User.queryInsertAttribute)*/					
//})

@Entity
@Table(name = "user_table")
@SQLInsert(sql = "insert into entities(entity_id) values(:id)")
//@SQLInsert( sql = "insert into user_table(name, id) values(?, ?)")
//@SQLInsert(sql = "insert into entities(type) values()")
//@SQLUpdate(sql = "UPDATE entities SET type_of_entity_id = ?, parent_id = ?  WHERE entity_id = ?")
/*@SqlResultSetMapping(name="getAllUser",
	entities=@EntityResult(entityClass=User.class,
	fields = {
		@FieldResult(name="id", column = "id"),
		@FieldResult(name="name", column = "name")
	}))*/
@SqlResultSetMapping(name="updateResult", columns = {
		@ColumnResult(name="count")
	
})
//@NamedNativeQuery(name="getAllUser", query="select id, name from user_table", resultSetMapping="getAllUser")


@NamedNativeQueries({
	@NamedNativeQuery(name = "updateUser", 	query = "UPDATE entities SET parent_id = 0, type_of_entity_id = 12 where entity_id = ?", resultSetMapping = "updateResult"),
	//@NamedNativeQuery(name="getAllUser", query="select id, name from user_table", resultSetMapping="getAllUser") 
})

public class User implements Commentable {

	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private String name;
	//private String surname;
	//private Date date;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}*/
	
	/*public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	*/
}
=======
package dev.models;

import dev.models.simpleentity.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "entities")
public class User {
    //static Integer entity_type_id = 0;
    
    public User() {

    }

    public User(String name, String surname) {
            //this.name = new Name(name);  
            //this.name.setUser(this);
            //this.surname = new Surname(surname);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id", unique = true, nullable = false)
    private Integer entity_id;
    

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    //@JoinColumn(name="name_fk")
    private Name name;

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private Surname surname;

    public Surname getSurname() {
        return surname;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }
    
    public Integer getId() {
        return entity_id;
    }

    public void setId(Integer id) {
        this.entity_id = id;
    }

    
    
    
    
    /*@OneToOne
    @JoinColumn(name="id_fk")
    private Surname surname;*/
    
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }    

    /*public Surname getSurname() {
        return surname;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }*/
}
>>>>>>> 28dc78b846c939704e35d66847d4408b8557839e
