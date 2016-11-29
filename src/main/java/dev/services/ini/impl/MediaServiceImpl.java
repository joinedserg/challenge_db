package dev.services.ini.impl;

import java.util.List;

import dev.dao.ini.MediaDao;
import dev.models.ini.TypeOfEntity;
import dev.services.ini.MediaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("storageService")
public class MediaServiceImpl implements MediaService {

	
	@Autowired
	private MediaDao dao;
	
	@Transactional
    public void save(TypeOfEntity type) {
		
		
        dao.save(type);
        
        
    }


    public List<TypeOfEntity> getAll() {
        return dao.getAll();
    }
    
}
