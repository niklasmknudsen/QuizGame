package dk.howard.service;

import dk.howard.domain.Answer;
import dk.howard.domain.Id;
import dk.howard.domain.Question;
import dk.howard.repository.QuestionRepository;
import dk.howard.service.request.AnsweredRequest;

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

    public Answer receiveAnswer(AnsweredRequest answeredRequest) {
        Question question = repository.getById(answeredRequest.getQuestionID());
        return question.findAnswer(answeredRequest.getAnswerID());
    }
}
