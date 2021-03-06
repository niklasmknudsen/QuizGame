package dk.QuizGame.service;

import dk.QuizGame.domain.Answer;
import dk.QuizGame.domain.Id;
import dk.QuizGame.repository.AnswerRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class AnswerService {

    private final AnswerRepository repository;

    @Inject
    public AnswerService(AnswerRepository repository) {
        this.repository = repository;
    }


    public void remove(Id id) {
        this.repository.getById(id);
    }

    public List<Answer> getAll() {
        return this.repository.getAll();
    }

    public void insert(Answer entity) {
        this.repository.insert(entity);
    }

    public Answer getById(Id id) {
        return this.repository.getById(id);
    }

    public List<Answer> getByQId(Id id) { return this.repository.getByQId(id);}


}
