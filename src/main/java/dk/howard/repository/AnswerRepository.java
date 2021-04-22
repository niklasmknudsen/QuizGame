package dk.howard.repository;

import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.repository.entitymanager.DemoEntityManager;
import dk.howard.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Dependent
public class AnswerRepository implements IRepository<AnswerPO> {

    private final EntityManager entityManager;

    @Inject
    public AnswerRepository(DemoEntityManager  entityManager) {
        this.entityManager = entityManager.getEntityManager();
    }

    @Override
    public AnswerPO remove(String id) {
        AnswerPO answerToRemove = entityManager.find(AnswerPO.class, id);
        entityManager.remove(answerToRemove);
        return answerToRemove;
    }

    @Override
    public List<AnswerPO> getAll() {
        return entityManager.createNamedQuery(AnswerPO.FIND_ALL, AnswerPO.class).getResultList();
    }

    @Override
    public void insert(AnswerPO entity) {
        AnswerPO newAnswer = new AnswerPO(entity.getAnswerName(), entity.getQuestion(), entity.isTrueAnswer(), entity.getExplanation(), entity.getUrl());
        this.entityManager.persist(newAnswer);
    }

    @Override
    public AnswerPO getById(String id) {
        return entityManager.find(AnswerPO.class, id);
    }
}
