package dev.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="relationship2")
//@IdClass(RelationshipPK.class)
//@SecondaryTable(name="types_attributes")
public class Relationship {
    //@Id
    //@GeneratedValue
    //private Integer id;
    
    //private Integer id;
    //@Id
//    @Column(name="entity_id1", 
//            insertable = true, updatable = false)
    @Id
    private Integer entity_id1;
    
    //@Id
//    @Column(name="entity_id2", 
//            insertable = true, updatable = false)
    private Integer entity_id2;
    
    //@JoinColumn(name="attribute_id", table="types_attributes")
    //@ManyToOne
    private String attribute_id;

    public Relationship(BaseEntity entity1, BaseEntity entity2, String attributeName) {
        this.entity_id1 = entity1.getId();
        this.entity_id2 = entity2.getId();
        attribute_id = "kk";
        //this.attribute_id = ContextType.getInstance().getTypeAttribute(attributeName);
    }
    
    public Integer getEntity_id1() {
        return entity_id1;
    }

    public void setEntity_id1(Integer entity_id1) {
        this.entity_id1 = entity_id1;
    }

    public Integer getEntity_id2() {
        return entity_id2;
    }

    public void setEntity_id2(Integer entity_id2) {
        this.entity_id2 = entity_id2;
    }

    public String getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(String attribute_id) {
        this.attribute_id = attribute_id;
    }
}