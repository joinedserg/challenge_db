package dev.models;

import dev.models.simpleentity.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "entities")
public class User {
    //static Integer entity_type_id = 0;
    
    public User() {
this.entity_id = 12;
    }

    public User(String name, String surname) {
        this.name = new Name(name);
            //this.name.setUser(this);
            //this.surname = new Surname(surname);
    }
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id", unique = true, nullable = false)
    private Integer entity_id;
    
    @MapsId("entity_id") 
    @OneToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name="name_fk")
    //@MapsId("entity_id")
    private Name name;

    //@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    //private Surname surname;

//    public Surname getSurname() {
//        return surname;
//    }
//
//    public void setSurname(Surname surname) {
//        this.surname = surname;
//    }
    
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
        
        this.name.setId(new NamePK(entity_id, 1));
    }    

    /*public Surname getSurname() {
        return surname;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }*/
}
