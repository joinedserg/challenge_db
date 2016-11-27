package dev.dao.ini;

import java.util.List;


import dev.models.ini.TypeOfAttribute;

public interface MediaDaoTypeOfAttribute {
    public void save(TypeOfAttribute entity);
    public List<TypeOfAttribute> getAll();


}
