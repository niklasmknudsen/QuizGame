package dk.howard.repository.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class AnswerPO {

    public static final String FIND_ALL = "AnswerPO.findAll";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name = "Answer_Name", columnDefinition = "VARCHAR(250)", nullable = false, updatable = true)
    private String answerName;

    @ManyToOne
    @JoinColumn(name = "QuestionID", referencedColumnName = "ID")
    private QuestionPO question;

    @Column(name = "True_Answer", nullable = false, updatable = true)
    private boolean trueAnswer;

    @Column(name = "Explanation", nullable = false, updatable = true)
    private String explanation;

    @Column(name = "URL", nullable = false, updatable = true)
    private String url;

    public AnswerPO(){
        this.question = null;
    }

    public AnswerPO(String answerName, QuestionPO question, boolean trueAnswer, String explanation, String url){
        this.answerName = answerName;
        this.question = question;
        this.trueAnswer = trueAnswer;
        this.explanation = explanation;
        this.url = url;
    }

    public void setQuestion(QuestionPO question){
        this.question = question;
    }

    public QuestionPO getQuestion(){
        return this.question;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + this.id);
        sb.append(", AnswerName: " + this.answerName);
        sb.append(", Question: " + this.question);
        sb.append(", TrueAnswer: " + this.trueAnswer);
        sb.append(", Explanation: " + this.explanation);
        sb.append(", URL: " + this.url);
        return sb.toString();
    }
}
