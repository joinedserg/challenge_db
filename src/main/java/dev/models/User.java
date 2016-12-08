package dev.models;

import javax.persistence.*;

import dev.models.BaseEntity;
import dev.ini.ContextType;

@Entity
@Table(name="entities")
public class User extends BaseEntity{

	public User() {
		super(User.class.getSimpleName());
		
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
