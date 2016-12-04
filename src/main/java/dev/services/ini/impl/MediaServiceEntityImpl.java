package dev.services.ini.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dev.models.BaseEntity;
import dev.dao.ini.MediaDaoEntity;
import dev.services.ini.MediaServiceEntity;

@Service("storageServiceUser")
public class MediaServiceEntityImpl implements MediaServiceEntity {

    @Autowired
    private MediaDaoEntity dao;

    @Transactional
    public void save(BaseEntity entity) {
        dao.save(entity);
    }

    @Transactional
    public void update(BaseEntity entity) {
        dao.update(entity);
    }
    
    @Transactional
    public void delete(BaseEntity entity) {
        dao.delete(entity);
    }
    
    public List<BaseEntity> getAll() {
        return dao.getAll();
    }
}
