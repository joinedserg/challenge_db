package dev.services.ini.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dev.dao.ini.MediaDaoUser;
import dev.models.User;
import dev.services.ini.MediaServiceUser;


@Service("storageServiceUser")
public class MediaServiceUserImpl implements MediaServiceUser {

	@Autowired
	private MediaDaoUser dao;
	
	
	@Transactional
	public void save(User user) {
		dao.save(user);
	}

	public List<User> getAll() {
		
		return dao.getAll();
	}



	
}
