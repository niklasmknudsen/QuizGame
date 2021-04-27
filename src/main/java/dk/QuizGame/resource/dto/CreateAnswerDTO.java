package dk.QuizGame.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CreateAnswerDTO {

    private final String answerName;

    private final boolean trueAnswer;

    private final String explanation;

    private final String url;

    @JsonCreator
    public CreateAnswerDTO(@JsonProperty("answerName")  String answerName,
                           @JsonProperty("trueAnswer") boolean trueAnswer,
                           @JsonProperty("explanation")  String explanation,
                           @JsonProperty("url")  String url){
        this.answerName = answerName;
        this.trueAnswer = trueAnswer;
        this.explanation = explanation;
        this.url = url;
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

    @Override
    public String toString() {
        return "CreateAnswerDTO{" +
                "answerName='" + answerName + '\'' +
                ", trueAnswer=" + trueAnswer +
                ", explanation='" + explanation + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
