package dev.models.simpleentity;

import dev.models.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "values")
public class Name   {
    
    public Name() {
        //this.attribute_id = 1;
    }
    
    public Name(String name) {
        //this.attribute_id = 1;
        this.name = name;
    }
    
    @Id
    @GeneratedValue
    private Integer attribute_id;    
    
    //@Id
    @OneToOne
    @JoinColumn(name="entity_id")
    private User user;
 
    
    static {
        //attribute_id = 1;
    }
    
    @Column(name = "text_value")
    private String name;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Integer getAttribute_id() {
        return attribute_id;
    }

    public String getName() {
        return name;
    }

    public void setAttribute_id(Integer attribute_id) {
        this.attribute_id = attribute_id;
    }

    public void setName(String name) {
        this.name = name;
    }    
}