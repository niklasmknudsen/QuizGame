package dk.howard.service;

import dk.howard.repository.QuestionRepository;
import dk.howard.repository.Repository;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateQuestionDTO;

import javax.inject.Inject;
import java.util.List;

public class QuestionService {

    private final QuestionRepository repository;

    @Inject
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuestionPO> findAllQuestions(){
        return repository.findAll();
    }

    public void insert(CreateQuestionDTO createQuestionDTO){
        repository.insert(createQuestionDTO);
    }

    public QuestionPO remove(String id){
        return repository.remove(id);
    }

    public QuestionPO getById(String id){
        return repository.getById(id);
    }
}
