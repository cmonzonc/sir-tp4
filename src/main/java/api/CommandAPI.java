package api;

import java.util.Collection;

public interface CommandAPI<objectScope> {
	
	objectScope get(Object identifier);
    boolean put(objectScope entity);
    objectScope update(objectScope entity);
    objectScope remove(objectScope identifier);
    Collection<objectScope> findAll();

}
