package dk.howard.service;

import dk.howard.repository.QuestionRepository;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateQuestionDTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class QuestionService {

    private final QuestionRepository repository;

    @Inject
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuestionPO> getAllQuestions(){
        return repository.getAll();
    }

    public void insert(QuestionPO questionPO){
        repository.insert(questionPO);
    }

    public void remove(int id){
        repository.remove(id);
    }

    public QuestionPO getById(int id){
        return repository.getById(id);
    }
}
