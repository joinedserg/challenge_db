package dev.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import dev.ini.ContextType;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "entities")
//@DiscriminatorValue(value="Chal")
public class ChallengeRoadMap extends BaseEntity {

    public ChallengeRoadMap() {
        super(ChallengeRoadMap.class.getSimpleName());
    }

    public String getName() {
        return this.getAttributes()
                .get(ContextType.getInstance().getTypeAttribute("name").getId()).getValue();
    }

    public void setName(String name) {
        this.getAttributes()
                .get(ContextType.getInstance().getTypeAttribute("name").getId()).setValue(name);
    }
}
