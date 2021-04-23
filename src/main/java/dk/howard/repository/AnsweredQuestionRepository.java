package dk.howard.repository;

import dk.howard.domain.AnsweredQuestion;
import dk.howard.domain.Id;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import dk.howard.repository.entitymanager.DemoEntityManager;
import dk.howard.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Dependent
public class AnsweredQuestionRepository implements IRepository<AnsweredQuestion> {

    private final EntityManager entityManager;
    private final Mapper mappper;

    @Inject
    public AnsweredQuestionRepository(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mappper = mapper;
    }

    @Override
    public void remove(Id id) {
        AnsweredQuestionPO answeredQuestionToRemove = entityManager.find(AnsweredQuestionPO.class, id);
        this.entityManager.remove(answeredQuestionToRemove);
    }

    @Override
    public List<AnsweredQuestion> getAll() {
        return mappper.mapAnsweredQuestions(
                entityManager.createNamedQuery(AnsweredQuestionPO.FIND_ALL, AnsweredQuestionPO.class)
                        .getResultList());
    }

    @Override
    public void insert(AnsweredQuestion entity) {
        AnsweredQuestionPO newAnsweredQuestion = mappper.mapAnsweredQuestionPO(entity);
        this.entityManager.persist(newAnsweredQuestion);
    }

    @Override
    public AnsweredQuestion getById(Id id) {
        AnsweredQuestion answeredQuestion = mappper.mapAnsweredQuestion(entityManager.find(AnsweredQuestionPO.class, id));
        return answeredQuestion;
    }
}
