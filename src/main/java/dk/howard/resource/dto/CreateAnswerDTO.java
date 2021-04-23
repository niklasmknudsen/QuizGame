package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.domain.Id;
import dk.howard.domain.Question;


public class CreateAnswerDTO {

    private Id id;

    private final String answerName;

    private final Question question;

    private final boolean trueAnswer;

    private final String explanation;

    private final String url;

    @JsonCreator
    public CreateAnswerDTO(@JsonProperty("answerName")  String answerName,
                           @JsonProperty("question") Question question,
                           @JsonProperty("trueAnswer") boolean trueAnswer,
                           @JsonProperty("explanation")  String explanation,
                           @JsonProperty("url")  String url){
        this.answerName = answerName;
        this.question = question;
        this.trueAnswer = trueAnswer;
        this.explanation = explanation;
        this.url = url;
    }

    public Id getId() {
        return id;
    }

    public String getAnswerName() {
        return answerName;
    }

    public Question getQuestion() {
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
        return "CreateAnswerDTO{" +
                "answerName='" + answerName + '\'' +
                ", question=" + question +
                ", trueAnswer=" + trueAnswer +
                ", explanation='" + explanation + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
