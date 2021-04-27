package dk.QuizGame.repository.entity;

import dk.QuizGame.domain.Category;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Question")
@NamedQueries({@NamedQuery(name = "QuestionPO.findAll", query = "Select u from QuestionPO u")})
public class QuestionPO {

    public static final String FIND_ALL = "QuestionPO.findAll";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name = "Category", columnDefinition = "VARCHAR(250)", nullable = false, updatable = true)
    private Category category;

    @Column(name = "Field", columnDefinition = "VARCHAR(250)", nullable = false, updatable = true)
    private String field;

    @Column(name = "Description", columnDefinition = "VARCHAR(500)", nullable = false, updatable = true)
    private String description;

    @Column(name = "Points", columnDefinition = "INT", nullable = false, updatable = true)
    private int points;

    @OneToOne(mappedBy = "questionPO")
    private AnsweredQuestionPO answeredQuestionPO;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<AnswerPO> answers;

    public QuestionPO(Category category, String field, String description,int points){
        this.category = category;
        this.field = field;
        this.description = description;
        this.points = points;
        this.answers = new ArrayList<>();
    }

    public QuestionPO() {
    }

    public void addAnswer(AnswerPO answer){
        answer.setQuestion(this);
        getAnswers().add(answer);
    }

    public List<AnswerPO> getAnswers(){
        if (answers == null) {
            answers = new ArrayList<>();
        }
        return answers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public String getField() {
        return field;
    }

    public int getPoints() {
        return points;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + this.id);
        sb.append(", Category: " + this.category);
        sb.append(", Field: " + this.field);
        sb.append(", Points: " + this.points);
        sb.append(", Description: " + this.description);
        return sb.toString();
    }

}
