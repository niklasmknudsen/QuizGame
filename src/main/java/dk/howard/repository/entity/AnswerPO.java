package dk.howard.repository.entity;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "Answer")
@NamedQueries({
                @NamedQuery(name = "AnswerPO.findAll", query = "Select q from AnswerPO q"),
                @NamedQuery(name = "AnswerPO.findByQID", query = "select q from AnswerPO q where q.question=:QID")
})
public class AnswerPO {

    public static final String FIND_ALL = "AnswerPO.findAll";
    public static final String QID_PARAMETER = "QID";
    public static final String FIND_BY_QID = "AnswerPO.findByQID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int" , nullable = false, updatable = false, unique = true)
    @XmlElement(name = "id", required = false)
    private int id;

    @Column(name = "Answer_Name", columnDefinition = "VARCHAR(250)", nullable = false, updatable = true)
    @XmlElement(name = "answerName", required = true)
    private String answerName;

    @Column(name = "True_Answer", nullable = false, updatable = true)
    @XmlElement(name = "trueAnswer", required = true)
    private boolean trueAnswer;

    @Column(name = "Explanation", nullable = false, updatable = true)
    @XmlElement(name = "explanation", required = true)
    private String explanation;

    @Column(name = "URL", nullable = false, updatable = true)
    @XmlElement(name = "url", required = true)
    private String url;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "questions", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @XmlElement(name = "question", required = true)
    private QuestionPO question;

    public AnswerPO(){
        this.question = null;
    }

    public AnswerPO(String answerName, boolean trueAnswer, String explanation, String url, QuestionPO question){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        sb.append("id: " + this.id);
        sb.append(", AnswerName: " + this.answerName);
        sb.append(", Question: " + this.question);
        sb.append(", TrueAnswer: " + this.trueAnswer);
        sb.append(", Explanation: " + this.explanation);
        sb.append(", URL: " + this.url);
        return sb.toString();
    }
}
