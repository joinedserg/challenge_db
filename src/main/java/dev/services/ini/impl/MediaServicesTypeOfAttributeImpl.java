package dev.services.ini.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dev.dao.ini.MediaDaoTypeOfAttribute;
import dev.models.ini.TypeOfAttribute;
import dev.services.ini.MediaServicesTypeOfAttribute;

public class MediaServicesTypeOfAttributeImpl implements MediaServicesTypeOfAttribute {
	
	@Autowired
	private MediaDaoTypeOfAttribute dao;
	
	@Transactional
    public void save(TypeOfAttribute type) {
        dao.save(type);
    }


    public List<TypeOfAttribute> getAll() {
        return dao.getAll();
    }
}
