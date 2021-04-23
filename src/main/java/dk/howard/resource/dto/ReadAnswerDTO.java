package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.domain.*;

import java.util.UUID;

public class ReadAnswerDTO {

    private final String id;

    private final String answerName;

    private final boolean trueAnswer;

    private final String explanation;

    private final String url;

    @JsonManagedReference
    private final Question question;

    public ReadAnswerDTO(
            String id,
            String answerName,
            boolean trueAnswer,
            String explanation,
            String url,
            Question question){
        this.id = id;
        this.answerName = answerName;
        this.question = question;
        this.trueAnswer = trueAnswer;
        this.explanation = explanation;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getAnswerName() {
        return answerName;
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

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "ReadAnswerDTO{" +
                "id='" + id + '\'' +
                ", answerName='" + answerName + '\'' +
                ", trueAnswer=" + trueAnswer +
                ", explanation='" + explanation + '\'' +
                ", url='" + url + '\'' +
                ", question=" + question +
                '}';
    }
}
