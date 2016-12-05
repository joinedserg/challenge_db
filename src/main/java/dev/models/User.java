package dev.models;

import java.util.*;

import javax.persistence.*;

//@Entity
//@Table(name = "entities")
public class User {

    public User() {
        this.attributes = new HashMap<String, Attribute>();
    }

    public User(String name, String surname) {
        this.attributes = new HashMap<String, Attribute>();

        attributes.put("name", new Attribute(0, name));
        attributes.put("surname", new Attribute(1, surname));

    }

    private Integer entity_id;
    private Map<String, Attribute> attributes;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entity_id")
    public Integer getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Integer entity_id) {
        this.entity_id = entity_id;
    }

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "entity_id")
    
    public List<Attribute> getAttr() {
        return new ArrayList(attributes.values());
    }

    public void setAttr(List<Attribute> list) {
        //TODO: !!!!!!!
       System.out.println("setAttr!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }

}
