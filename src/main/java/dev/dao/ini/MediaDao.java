package dev.dao.ini;

import dev.models.ini.TypeOfEntity;

import java.util.List;

public interface MediaDao {

    public void save(TypeOfEntity entity);
    public List<TypeOfEntity> getAll();

}
