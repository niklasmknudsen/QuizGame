package dk.howard.repository.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Question")
@NamedQueries({@NamedQuery(name = "QuestionPO.findAll", query = "Select q from QuestionPO q")})
public class QuestionPO {

    public static final String FIND_ALL = "QuestionPO.findAll";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private Id id;

    @Column(name = "Category", columnDefinition = "VARCHAR(250)", nullable = false, updatable = true)
    private String category;

    @Column(name = "Field", columnDefinition = "VARCHAR(250)", nullable = false, updatable = true)
    private String field;

    @Column(name = "Description", columnDefinition = "VARCHAR(500)", nullable = false, updatable = true)
    private String description;

    @Column(name = "Points", columnDefinition = "INT", nullable = false, updatable = true)
    private int points;

    @OneToOne(mappedBy = "questionPO")
    private AnsweredQuestionPO answeredQuestionPO;

    @OneToMany(mappedBy = "Question", fetch = FetchType.EAGER)
    private List<AnswerPO> answers = new ArrayList<AnswerPO>();

    public QuestionPO(){
        this.answeredQuestionPO = null;
    }

    public QuestionPO(String category, String field, String description,int points){
        this.category = category;
        this.field = field;
        this.description = description;
        this.points = points;
    }

    public AnswerPO createAnswer(AnswerPO answer){
        AnswerPO newAnswer = new AnswerPO(answer.getAnswerName(), answer.getQuestion(), answer.isTrueAnswer(), answer.getExplanation(), answer.getUrl());
        this.answers.add(newAnswer);
        return newAnswer;
    }

    public void addAnswer(AnswerPO answer){
        if(!this.answers.contains(answer)){
            this.answers.add(answer);
        }
    }

    public void removeAnswer(AnswerPO answer){
        if(this.answers.contains(answer)){
            this.answers.remove(answer);
        }
    }

    public List<AnswerPO> getAnswers(){
        return new ArrayList<AnswerPO>(answers);
    }

    public AnsweredQuestionPO createAnsweredQuestion(AnsweredQuestionPO answeredQuestionPO){
        AnsweredQuestionPO newAQPO = new AnsweredQuestionPO();
        this.answeredQuestionPO = newAQPO;
        return newAQPO;
    }

    public AnsweredQuestionPO getAnsweredQuestion(){
        return this.answeredQuestionPO;
    }

    public void removeAnsweredQuestion(){
        this.answeredQuestionPO = null;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
