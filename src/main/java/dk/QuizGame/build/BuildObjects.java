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
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;

public class BuildObjects {

    private static final String PERSISTENCE_UNIT = "demo";

    @PersistenceContext(unitName = PERSISTENCE_UNIT)
    private EntityManager entityManager;


    public BuildObjects() { }


    public void seed() {

        QuestionPO q1 = new QuestionPO(Category.SCIENCE, "Physics","Wich physical property can be measured in the unit Coulomb" ,12);
        AnswerPO a1 = new AnswerPO("Force", false, "The SI unit for Force is Newton", "https://en.wikipedia.org/wiki/Force");
        AnswerPO a2 = new AnswerPO("Pressure", false,"The SI unit for Pressure is Pascal", "https://en.wikipedia.org/wiki/Pressure");
        AnswerPO a3 = new AnswerPO("Volume", false, "The SI unit for Volume is Cubic Meter",  "https://en.wikipedia.org/wiki/Volume");
        AnswerPO a4 = new AnswerPO("Charge", true, "The SI unit for Electric Charge is Coulomb", "https://en.wikipedia.org/wiki/Coulumb");
        AnswerPO a5 = new AnswerPO("Temperature", false, "The SI unit for Temperature is Kelvin", "https://en.wikipedia.org/wiki/Temperature");
        q1.addAnswer(a1);
        q1.addAnswer(a2);
        q1.addAnswer(a3);
        q1.addAnswer(a4);
        q1.addAnswer(a5);
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.persist(a3);
        entityManager.persist(a4);
        entityManager.persist(a5);


        QuestionPO q2 = new QuestionPO(Category.SCIENCE, "Computer science", "Which design pattern is mostly used???", 12);

        AnswerPO a6 = new AnswerPO("Singleton", true, "singleton creates a instance of an object, witch can only be created once", "https://en.wikipedia.org/wiki/Singleton_pattern");
        AnswerPO a7 = new AnswerPO("Adapter", false, "In software engineering, the adapter pattern is a software design pattern (also known as wrapper, an alternative naming shared with the decorator pattern) that allows the interface of an existing class to be used as another interface", "https://en.wikipedia.org/wiki/Adapter_pattern");
        AnswerPO a8 = new AnswerPO("Observer", false, "The observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.", "https://en.wikipedia.org/wiki/Observer_pattern" );
        AnswerPO a9 = new AnswerPO("Iterator", false, "In object-oriented programming, the iterator pattern is a design pattern in which an iterator is used to traverse a container and access the container's elements. The iterator pattern decouples algorithms from containers; in some cases, algorithms are necessarily container-specific and thus cannot be decoupled.", "https://en.wikipedia.org/wiki/Iterator_pattern");
        AnswerPO a10 = new AnswerPO("Composite", false, "In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes a group of objects that are treated the same way as a single instance of the same type of object. The intent of a composite is to compose objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly","https://en.wikipedia.org/wiki/Composite_pattern");

        q2.addAnswer(a6);
        q2.addAnswer(a7);
        q2.addAnswer(a8);
        q2.addAnswer(a9);
        q2.addAnswer(a10);
        entityManager.persist(a6);
        entityManager.persist(a7);
        entityManager.persist(a8);
        entityManager.persist(a9);
        entityManager.persist(a10);

        entityManager.persist(q1);
        entityManager.persist(q2);


    }
}
