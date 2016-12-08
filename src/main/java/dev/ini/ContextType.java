package dev.ini;

import dev.models.ini.TypeOfAttribute;
import dev.models.ini.TypeOfEntity;

import java.util.HashMap;
import java.util.Map;

public class ContextType {
    
    private static ContextType context;
    private ContextType() {
        availableAttributes = new HashMap();
        availableEntities = new HashMap();
    }
    
    public static ContextType getInstance() {
        if(context == null) {
            context = new ContextType();
        }
        
        return context;
    }
    
    private Map<String, TypeOfAttribute> availableAttributes;
    private Map<String, TypeOfEntity> availableEntities;
    //priva

    public TypeOfAttribute getTypeAttribute(String name) {
        return availableAttributes.get(name);
    }
    
    public TypeOfEntity getTypeEntity(String name) {
        return availableEntities.get(name);
    }
    
    public void add(TypeOfAttribute attr) {
        availableAttributes.put(attr.getName(), attr);
    }
    
    public void add(TypeOfEntity entity) {
        availableEntities.put(entity.getNameTypeEntity(), entity);
    }
}
