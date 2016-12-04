package dev.services.ini;

import java.util.List;

import dev.models.User;

public interface MediaServiceUser {
	
	public void save(User user);
	
	public List<User> getAll();
	
}
