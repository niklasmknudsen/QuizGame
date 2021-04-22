package dk.howard.service;

import dk.howard.repository.AnswerRepository;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.interfaces.IRepository;

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
