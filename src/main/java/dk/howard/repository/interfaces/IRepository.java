package dk.howard.repository.interfaces;

import java.util.HashSet;
import java.util.Set;

public interface IRepository<T> {
    public T remove(T entity);
    public Set<T> findAll();
    public void add(T entity);
    public T getById(String id);
}
