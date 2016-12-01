package dev.models.simpleentity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class NamePK implements Serializable {
    private Integer entity_id;
    private Integer attribute_id;

    public NamePK() {
 this.attribute_id = 1;
    }

    public NamePK(Integer entity_id, Integer attribute_id) {
            this.entity_id = entity_id;
            this.attribute_id = attribute_id;
    }


    public Integer getUser() {
            return entity_id;
    }

    public void setUser(Integer entity_id) {
            this.entity_id = entity_id;
    }

    public Integer getAttribute_id() {
            return attribute_id;
    }

    public void setAttribute_id(Integer attribute_id) {
            this.attribute_id = attribute_id;
    }

    @Override
    public boolean equals(Object o) {
        return this.entity_id == ((NamePK)o).entity_id && this.attribute_id == ((NamePK)o).attribute_id;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
