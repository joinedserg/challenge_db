package dev.services.ini;

import java.util.List;

import dev.models.ini.TypeOfAttribute;

public interface MediaServicesTypeOfAttribute {
	public void save(TypeOfAttribute type);
	
	public List<TypeOfAttribute> getAll();
}
