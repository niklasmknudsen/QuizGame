package dk.howard.repository.interfaces;

import dk.howard.domain.Id;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateQuestionDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IRepository<T> {
    public void remove(Id id);
    public List<T> getAll();
    public void insert(T entity);
    public T getById(Id id);
}
