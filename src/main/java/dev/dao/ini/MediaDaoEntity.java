package dev.dao.ini;

import java.util.List;

import dev.models.*;

public interface MediaDaoEntity {
	
    public void save(BaseEntity entity);
    public<T extends BaseEntity> List<T> getAll(Class classType);
    public void delete(BaseEntity entity);
    public void update(BaseEntity entity);
    
    public BaseEntity findById(Integer idEntity);
}
