package dev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import org.hibernate.annotations.WhereJoinTable;



@Entity
@Table(name = "entities")
@SecondaryTable(name="values")
public class User {
    //static Integer entity_type_id = 0;
    
    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id", unique = true, nullable = false)
    private Integer entity_id;
    
    
    
    @JoinTable(name="values",
            joinColumns=@JoinColumn(name = "entity_id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id")
    )
    @WhereJoinTable(clause = "attribute_id = 0")
    @Column(table="values", name="text_value")
    private String name;
   
    
    
    @JoinTable(name="values",
            joinColumns = @JoinColumn(name="entity_id"),
            inverseJoinColumns = @JoinColumn(name="entity_id")
    )
    @WhereJoinTable(clause = "attribute_id = 1")
    @Column(table="values", name="text_value")
    private String surname;
    
    
    @JoinTable(name="values",
            joinColumns=@JoinColumn(name = "entity_id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id")
    )
    @Column(table="values", name="attribute_id")
    private Integer name_attribute_id = 0;
    
    @JoinTable(name="values",
        joinColumns=@JoinColumn(name = "entity_id"), 
        inverseJoinColumns = @JoinColumn(name = "entity_id")
    )
    @Column(table="values", name="attribute_id")
    private Integer surname_attribute_id = 1;

        
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {        
        this.surname = surname;
    }

    public Integer getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Integer entity_id) {
        this.entity_id = entity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
