package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.domain.Answer;
import dk.howard.domain.Id;
import dk.howard.domain.Question;


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
