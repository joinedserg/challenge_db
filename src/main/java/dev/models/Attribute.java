package dev.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="values")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"entity_id", "attribute_id"})})
//@Table(name = "values")
public class Attribute implements Serializable {


	@AttributeOverrides({ 
		@AttributeOverride(name = "entity_id", column = @Column(name = "entity_id", nullable = false))//, 
		//@AttributeOverride(name = "idCorporativeEvent", column = @Column(name = "id_corporative_event", nullable = false))
	})
    @EmbeddedId
    private AttributePK key;
    
    public void setKey(AttributePK key) {
    	this.key = key;
    }
    
    public AttributePK getKey() {
    	return this.key;
    }
    

    @Column(name = "text_value", updatable = true)
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;

        Attribute target = (Attribute) o;

        //if (this.target != target.target) return false;
        if (key != null ? !key.equals(target.key) : target.key != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        //result = 31 * result + target;
        return result;
    }
    
    
}








