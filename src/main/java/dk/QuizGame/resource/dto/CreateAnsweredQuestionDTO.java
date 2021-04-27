package dk.QuizGame.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CreateAnsweredQuestionDTO {

    private final String answer;

    @JsonCreator
    public CreateAnsweredQuestionDTO(@JsonProperty("answer") String answer) {
        this.answer = answer;
    }


    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "CreateAnsweredQuestionDTO{" +
                ", answerPO=" + answer +
                '}';
    }
}
