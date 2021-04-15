package dk.howard.repository.interfaces;

import dk.howard.resource.dto.CreateQuestionDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IRepository<T> {
    public T remove(String id);
    public List<T> findAll();
    public void insert(CreateQuestionDTO entity);
    public T getById(String id);
}
