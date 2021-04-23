package dk.howard.repository;

import dk.howard.domain.Answer;
import dk.howard.domain.Id;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.repository.entitymanager.DemoEntityManager;
import dk.howard.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Dependent
public class AnswerRepository implements IRepository<Answer> {

    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public AnswerRepository(DemoEntityManager  entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }

    @Override
    public void remove(Id id) {
        AnswerPO answerToRemove = entityManager.find(AnswerPO.class, id);
        entityManager.remove(answerToRemove);
    }

    @Override
    public List<Answer> getAll() {
        return mapper.mapAnswers(entityManager.createNamedQuery(AnswerPO.FIND_ALL, AnswerPO.class).getResultList());
    }

    @Override
    public void insert(Answer entity) {
        AnswerPO newAnswer = mapper.mapAnswerPO(entity);
        this.entityManager.persist(newAnswer);
    }

    @Override
    public Answer getById(Id id) {
        Answer foundAnswer = mapper.mapAnswer(entityManager.find(AnswerPO.class, id));
        return foundAnswer;
    }

    public List<Answer> getByQId(Id id) {
        try {
            return mapper.mapAnswers(entityManager.createNamedQuery(AnswerPO.FIND_BY_QID, AnswerPO.class)
                    .setParameter(AnswerPO.QID_PARAMETER, id)
                    .getResultList());
        } catch (NoResultException e) {
            return null;
        }
    }
}
