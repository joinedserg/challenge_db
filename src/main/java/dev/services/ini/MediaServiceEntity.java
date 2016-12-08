package dev.services.ini;

import java.util.List;

import dev.models.*;

public interface MediaServiceEntity {

    public void save(BaseEntity entity);

    public List<BaseEntity> getAll();
    
    public void update(BaseEntity entity);
    
    public void delete(BaseEntity entity);

    public BaseEntity findById(Integer idEntity);
    
}
