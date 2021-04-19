package dk.howard.service;

import dk.howard.repository.AnswerRepository;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.interfaces.IRepository;

import java.util.List;

public class AnswerService {

    private final AnswerRepository repository;

    public AnswerService(AnswerRepository repository) {
        this.repository = repository;
    }


    public AnswerPO remove(String id) {
        return this.repository.getById(id);
    }

    public List<AnswerPO> getAll() {
        return this.repository.getAll();
    }

    public void insert(AnswerPO entity) {
        this.repository.insert(entity);
    }

    public AnswerPO getById(String id) {
        return this.repository.getById(id);
    }
}
