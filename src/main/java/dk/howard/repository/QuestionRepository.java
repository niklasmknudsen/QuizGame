package dk.howard.repository;

import dk.howard.domain.Id;
import dk.howard.domain.Question;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.repository.entitymanager.DemoEntityManager;
import dk.howard.repository.interfaces.IRepository;
import dk.howard.repository.Mapper;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Dependent
public class QuestionRepository implements IRepository<Question> {

    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public QuestionRepository(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }

    @Override
    public void remove(Id id) {
        QuestionPO questionToRemove = entityManager.find(QuestionPO.class, id);
        entityManager.remove(questionToRemove);
    }

    @Override
    public List<Question> getAll() {
        return null;
        //return entityManager.createNamedQuery(QuestionPO.FIND_ALL, QuestionPO.class).getResultList();
    }

    @Override
    public void insert(Question entity) {
        QuestionPO newQuestion = new QuestionPO(
                entity.getCategory(),
                entity.getField().getField(),
                entity.getDescription().getDescription(),
                entity.getPoints().getPoints());
        entityManager.persist(newQuestion); // flushes new object to db.
    }

    @Override
    public Question getById(Id id) {
        Question foundQuestion = mapper.mapQuestion(entityManager.find(QuestionPO.class, id));
        return foundQuestion;
    }
}
