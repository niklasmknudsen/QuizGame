package dk.howard.service;

import dk.howard.domain.Id;
import dk.howard.domain.Question;
import dk.howard.repository.QuestionRepository;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateQuestionDTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class QuestionService {

    private final QuestionRepository repository;

    @Inject
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<Question> getAllQuestions(){
        return repository.getAll();
    }

    public void insert(Question question){
        repository.insert(question);
    }

    public void remove(Id id){
        repository.remove(id);
    }

    public Question getById(Id id){
        return repository.getById(id);
    }
}
