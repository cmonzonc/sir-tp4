package api;

import java.util.Collection;

public interface CommandAPI<T> {
	
	T get(Object identifier);
    boolean put(T entity);
    T update(T entity);
    T remove(T identifier);
    Collection<T> findAll();

}

