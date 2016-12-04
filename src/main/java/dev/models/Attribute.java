package dev.models;

import javax.persistence.*;

@Entity
@Table(name = "values")
public class Attribute {

    public Attribute() {
    }

    public Attribute(Integer attribute_id, String value) {
        this.attribute_id = attribute_id;
        this.value = value;
    }

    @Id
    //@GeneratedValue
    @Column(name = "attribute_id", nullable = false)
    private Integer attribute_id;

    @Column(name = "text_value", updatable = true)
    private String value;

    @ManyToOne
    //@JoinColumn(name="entity_id", updatable=true)
    //@Column(name="entity_id")
    private BaseEntity entity;

    public BaseEntity getEntity() {
        return entity;
    }

    public void setEntity(BaseEntity entity) {
        this.entity = entity;
    }
 
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
