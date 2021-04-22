package dk.howard.repository;

import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import dk.howard.repository.entitymanager.DemoEntityManager;
import dk.howard.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Dependent
public class AnsweredQuestionRepository implements IRepository<AnsweredQuestionPO> {

    private final EntityManager entityManager;


    @Inject
    public AnsweredQuestionRepository(DemoEntityManager entityManager) {
        this.entityManager = entityManager.getEntityManager();
    }

 //   @Override
    public AnsweredQuestionPO remove(String id) {
        AnsweredQuestionPO answeredQuestionToRemove = this.entityManager.find(AnsweredQuestionPO.class, id);
        this.entityManager.remove(answeredQuestionToRemove);
        return answeredQuestionToRemove;
    }

  //  @Override
    public List<AnsweredQuestionPO> getAll() {
        return entityManager.createNamedQuery(AnsweredQuestionPO.FIND_ALL, AnsweredQuestionPO.class).getResultList();
    }

   // @Override
    public void insert(AnsweredQuestionPO entity) {
        AnsweredQuestionPO newAnsweredQuestion = new AnsweredQuestionPO(entity.getQuestionPO(), entity.getAnswerPO());
        this.entityManager.persist(newAnsweredQuestion);
    }

   // @Override
    public AnsweredQuestionPO getById(String id) {
        return entityManager.find(AnsweredQuestionPO.class, id);
    }
}
