package dk.howard.service;

import dk.howard.repository.AnsweredQuestionRepository;
import dk.howard.repository.entity.AnsweredQuestionPO;

import java.util.List;

public class AnsweredQuestionService {

    private AnsweredQuestionRepository repository;

    public AnsweredQuestionService(AnsweredQuestionRepository repository) {
        this.repository = repository;
    }


    public AnsweredQuestionPO remove(String id) {
        return this.repository.remove(id);
    }

    public List<AnsweredQuestionPO> getAll() {
        return this.repository.getAll();
    }

    public void insert(AnsweredQuestionPO entity) {
        this.repository.insert(entity);
    }

    public AnsweredQuestionPO getById(String id) {
        return this.repository.getById(id);
    }
}
