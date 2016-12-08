package dev.services.ini.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dev.dao.ini.MediaDaoTypeOfEntity;
import dev.models.ini.TypeOfEntity;
import dev.services.ini.MediaServiceTypeOfEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("storageServiceTypeOfEntity")
public class MediaServiceTypeOfEntityImpl implements MediaServiceTypeOfEntity {

    @Autowired
    private MediaDaoTypeOfEntity dao;
    
    @Override
    @Transactional
    public void save(TypeOfEntity type) {
        dao.save(type);
    }
    
}
