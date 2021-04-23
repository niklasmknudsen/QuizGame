package dk.howard.service;

import dk.howard.repository.AnsweredQuestionRepository;
import dk.howard.repository.entity.AnsweredQuestionPO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class AnsweredQuestionService {

    private AnsweredQuestionRepository repository;

    @Inject
    public AnsweredQuestionService(AnsweredQuestionRepository repository) {
        this.repository = repository;
    }


    public void remove(int id) {
        this.repository.remove(id);
    }

    public List<AnsweredQuestionPO> getAll() {
        return this.repository.getAll();
    }

    public void insert(AnsweredQuestionPO entity) {
        this.repository.insert(entity);
    }

    public AnsweredQuestionPO getById(int id) {
        return this.repository.getById(id);
    }
}
