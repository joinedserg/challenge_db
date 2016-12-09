package dev.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import dev.ini.ContextType;
import dev.models.BaseEntity;


@Entity
@Table(name="entities")
@DiscriminatorValue("'GenericClient'")
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
