package dev.models.simpleentity;


import dev.models.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "values")
public class Surname {
    
    public Surname() {
    }
    
    public Surname(String surname) {
        this.surname = surname;
    }
    
    @Id
    @GeneratedValue
    private Integer attribute_id;    
    
    @OneToOne
    @JoinColumn(name="entity_id")
    private User user;
 
    @Column(name = "text_value")
    private String surname;

    public Integer getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(Integer attribute_id) {
        this.attribute_id = attribute_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
