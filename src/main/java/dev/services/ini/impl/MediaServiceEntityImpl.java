package dev.services.ini.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dev.models.*;
import dev.dao.ini.MediaDaoEntity;
import dev.services.ini.MediaServiceEntity;

@Service("storageServiceUser")
public class MediaServiceEntityImpl implements MediaServiceEntity {

    @Autowired
    private MediaDaoEntity dao;

    @Override
    @Transactional
    public void save(BaseEntity entity) {
        dao.save(entity);
    }

    @Override
    @Transactional
    public void update(BaseEntity entity) {
        dao.update(entity);
    }
    
    @Override
    @Transactional
    public void delete(BaseEntity entity) {
    	
    	//BaseEntity entity1 = dao.findById(entity.getId());
    	
        dao.delete(entity);
    }
    
    @Override
    public List<BaseEntity> getAll(Class classType) {
        return dao.getAll(classType);
    }

	@Override
	public BaseEntity findById(Integer idEntity) {
		return dao.findById(idEntity);
	}
    
    
    
}
