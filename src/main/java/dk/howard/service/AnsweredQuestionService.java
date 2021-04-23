package dk.howard.service;

import dk.howard.domain.AnsweredQuestion;
import dk.howard.domain.Id;
import dk.howard.repository.AnsweredQuestionRepository;
import dk.howard.repository.entity.AnsweredQuestionPO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class AnsweredQuestionService {

    private AnsweredQuestionRepository repository;

    @Inject
    public AnsweredQuestionService(AnsweredQuestionRepository repository) {
        this.repository = repository;
    }


    public void remove(Id id) {
        this.repository.remove(id);
    }

    public List<AnsweredQuestion> getAll() {
        return this.repository.getAll();
    }

    public void insert(AnsweredQuestion entity) {
        this.repository.insert(entity);
    }

    public AnsweredQuestion getById(Id id) {
        return this.repository.getById(id);
    }
}
