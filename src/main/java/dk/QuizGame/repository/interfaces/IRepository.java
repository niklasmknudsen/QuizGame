package dk.QuizGame.repository.interfaces;

import dk.QuizGame.domain.Id;

import java.util.List;

public interface IRepository<T> {
    public void remove(Id id);
    public List<T> getAll();
    public void insert(T entity);
    public T getById(Id id);
}
