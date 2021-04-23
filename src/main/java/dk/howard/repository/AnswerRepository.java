package dk.howard.repository;

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
public class AnswerRepository implements IRepository<AnswerPO> {

    private final EntityManager entityManager;

    @Inject
    public AnswerRepository(DemoEntityManager  entityManager) {
        this.entityManager = entityManager.getEntityManager();
    }



    @Override
    public void remove(int id) {
        AnswerPO answerToRemove = entityManager.find(AnswerPO.class, id);
        entityManager.remove(answerToRemove);
    }

    @Override
    public List<AnswerPO> getAll() {
        return entityManager.createNamedQuery(AnswerPO.FIND_ALL, AnswerPO.class).getResultList();
    }

    @Override
    public void insert(AnswerPO entity) {
        AnswerPO newAnswer = new AnswerPO(entity.getAnswerName(), entity.isTrueAnswer(), entity.getExplanation(), entity.getUrl(), entity.getQuestion());
        this.entityManager.persist(newAnswer);
    }

    @Override
    public AnswerPO getById(int id) {
        AnswerPO po = entityManager.find(AnswerPO.class, id);
        return new AnswerPO(po.getAnswerName(), po.isTrueAnswer(), po.getExplanation(), po.getUrl(), po.getQuestion());
    }

    public List<AnswerPO> getByQId(int id) {
        try {
            return entityManager.createNamedQuery(AnswerPO.FIND_BY_QID, AnswerPO.class)
                    .setParameter(AnswerPO.QID_PARAMETER, id)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
