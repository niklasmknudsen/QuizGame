package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.repository.entity.QuestionPO;

import javax.persistence.*;

public class ReadAnswerDTO {

    private int id;

    private final String answerName;

    @JsonManagedReference
    private final QuestionPO question;

    private final boolean trueAnswer;

    private final String explanation;

    private final String url;

    @JsonCreator
    public ReadAnswerDTO(
                         @JsonProperty("Id") int id,
                         @JsonProperty("answerName") String answerName,
                         @JsonProperty("trueAnswer") boolean trueAnswer,
                         @JsonProperty("explanation") String explanation,
                         @JsonProperty("url") String url,
                         @JsonProperty("question") QuestionPO question){
        this.answerName = answerName;
        this.question = question;
        this.trueAnswer = trueAnswer;
        this.explanation = explanation;
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAnswerName() {
        return answerName;
    }

    public QuestionPO getQuestion() {
        return question;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ReadAnswerDTO{" +
                "id=" + id +
                ", answerName='" + answerName + '\'' +
                ", question=" + question +
                ", trueAnswer=" + trueAnswer +
                ", explanation='" + explanation + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
