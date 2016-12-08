package dev.services.ini.impl;

import dev.dao.ini.MediaDaoTypeOfAttribute;
import dev.models.ini.TypeOfAttribute;
import dev.services.ini.MediaServiceTypeOfAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("storageServiceTypeOfAttribute")
public class MediaServiceTypeOfAttributeImpl implements MediaServiceTypeOfAttribute {

    @Autowired
    private MediaDaoTypeOfAttribute dao;
    
    @Override
    @Transactional
    public void save(TypeOfAttribute type) {
        dao.save(type);
    }
}
