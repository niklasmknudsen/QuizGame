package dk.howard.repository.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "AnsweredQuestion")
public class AnsweredQuestionPO {

    public static final String FIND_ALL = "AnsweredQuestionPO.findAll";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Question", referencedColumnName = "ID")
    private QuestionPO questionPO;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private AnswerPO answerPO;

    public AnsweredQuestionPO(){
        this.questionPO = null;
        this.answerPO = null;
    }

    public AnsweredQuestionPO(QuestionPO question, AnswerPO answer){
        this.questionPO = question;
        this.answerPO = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuestionPO getQuestionPO() {
        return questionPO;
    }

    public void setQuestionPO(QuestionPO questionPO) {
        this.questionPO = questionPO;
    }

    public AnswerPO getAnswerPO() {
        return answerPO;
    }

    public void setAnswerPO(AnswerPO answerPO) {
        this.answerPO = answerPO;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + this.id);
        sb.append(", Question: " + this.questionPO);
        sb.append(", Answer: " + this.answerPO);
        return sb.toString();
    }
}
