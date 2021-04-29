package dk.QuizGame.build;

import dk.QuizGame.domain.Category;
import dk.QuizGame.repository.AnswerRepository;
import dk.QuizGame.repository.QuestionRepository;
import dk.QuizGame.repository.entity.AnswerPO;
import dk.QuizGame.repository.entity.QuestionPO;
import dk.QuizGame.repository.entitymanager.DemoEntityManager;
import io.helidon.integrations.cdi.jpa.PersistenceUnitInfoBean;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

public class buildObjects {

    private final EntityManager entityManager;

    @Inject
    public  buildObjects(DemoEntityManager entityManager) {
        this.entityManager = entityManager.getEntityManager();
    }

    public void seed() {

        QuestionPO q1 = new QuestionPO(Category.SCIENCE, "Physics","Wich physical property can be measured in the unit Coulomb" ,12);
        q1.addAnswer(new AnswerPO("Force", false, "The SI unit for Force is Newton", "https://en.wikipedia.org/wiki/Force"));
        q1.addAnswer(new AnswerPO("Pressure", false,"The SI unit for Pressure is Pascal", "https://en.wikipedia.org/wiki/Pressure"));
        q1.addAnswer(new AnswerPO("Volume", false, "The SI unit for Volume is Cubic Meter",  "https://en.wikipedia.org/wiki/Volume"));
        q1.addAnswer(new AnswerPO("Charge", true, "The SI unit for Electric Charge is Coulomb", "https://en.wikipedia.org/wiki/Coulumb"));
        q1.addAnswer(new AnswerPO("Temperature", false, "The SI unit for Temperature is Kelvin", "https://en.wikipedia.org/wiki/Temperature"));

        QuestionPO q2 = new QuestionPO(Category.SCIENCE, "Computer science", "Which design pattern is mostly used???", 12);
        q2.addAnswer(new AnswerPO("Singleton", true, "singleton creates a instance of an object, witch can only be created once", "https://en.wikipedia.org/wiki/Singleton_pattern"));
        q2.addAnswer(new AnswerPO("Adapter", false, "In software engineering, the adapter pattern is a software design pattern (also known as wrapper, an alternative naming shared with the decorator pattern) that allows the interface of an existing class to be used as another interface", "https://en.wikipedia.org/wiki/Adapter_pattern"));
        q2.addAnswer(new AnswerPO("Observer", false, "The observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.", "https://en.wikipedia.org/wiki/Observer_pattern" ));
        q2.addAnswer(new AnswerPO("Iterator", false, "In object-oriented programming, the iterator pattern is a design pattern in which an iterator is used to traverse a container and access the container's elements. The iterator pattern decouples algorithms from containers; in some cases, algorithms are necessarily container-specific and thus cannot be decoupled.", "https://en.wikipedia.org/wiki/Iterator_pattern"));
        q2.addAnswer(new AnswerPO("Composite", false, "In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes a group of objects that are treated the same way as a single instance of the same type of object. The intent of a composite is to compose objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly","https://en.wikipedia.org/wiki/Composite_pattern"));

        entityManager.persist(q1);
        entityManager.persist(q2);


    }
}
