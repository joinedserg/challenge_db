package dev.dao.ini;

import java.util.List;
import dev.models.User;

public interface MediaDaoUser {

	public void add(User user);
	
    public void save(User user);
    public List<User> getAll();
    
}
