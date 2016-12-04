package dev.dao.ini;

import java.util.List;
import dev.models.BaseEntity;

public interface MediaDaoEntity {
	
    public void save(BaseEntity entity);
    public List<BaseEntity> getAll();
    public void delete(BaseEntity entity);
    public void update(BaseEntity entity);
}
