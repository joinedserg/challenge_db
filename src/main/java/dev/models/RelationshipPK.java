package dev.models;

import java.io.Serializable;
import javax.persistence.Column;

public class RelationshipPK implements Serializable {
    @Column(name="entity_id1")
    private Integer entity_id1;
    
    @Column(name="entity_id2")
    private Integer entity_id2;

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
}

