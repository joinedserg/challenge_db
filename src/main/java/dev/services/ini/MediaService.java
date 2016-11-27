package dev.services.ini;

import dev.models.ini.TypeOfEntity;

import java.util.List;

public interface MediaService {
	
	public void save(TypeOfEntity type);
	
	public List<TypeOfEntity> getAll();
	
}
