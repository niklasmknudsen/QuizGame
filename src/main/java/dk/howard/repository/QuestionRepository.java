package dk.howard.repository;

import dk.howard.repository.entity.QuestionPO;
import dk.howard.repository.entitymanager.DemoEntityManager;
import dk.howard.repository.interfaces.IRepository;
import dk.howard.resource.dto.CreateQuestionDTO;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionRepository implements IRepository<QuestionPO> {

    private final EntityManager entityManager;

    @Inject
    public QuestionRepository(DemoEntityManager entityManager) {
        this.entityManager = entityManager.getEntityManager();
    }

    @Override
    public QuestionPO remove(String id) {
        QuestionPO questionToRemove = entityManager.find(QuestionPO.class, id);
        entityManager.remove(questionToRemove);
        return questionToRemove;
    }

    @Override
    public List<QuestionPO> findAll() {
        return entityManager.createNamedQuery(QuestionPO.FIND_ALL, QuestionPO.class).getResultList();
    }

    @Override
    public void insert(CreateQuestionDTO entity) {
        QuestionPO newQuestion = new QuestionPO(entity.getCategory(), entity.getField(), entity.getDescription(), entity.getPoints());
        entityManager.persist(newQuestion);
    }

    @Override
    public QuestionPO getById(String id) {
        QuestionPO selectedQuestion = entityManager.find(QuestionPO.class, id);
        return selectedQuestion;
    }
}
