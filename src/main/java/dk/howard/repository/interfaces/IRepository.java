package dk.howard.repository.interfaces;

import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateQuestionDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IRepository<T> {
    public void remove(int id);
    public List<T> getAll();
    public void insert(T entity);
    public T getById(int id);
}
