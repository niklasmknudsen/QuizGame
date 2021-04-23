package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.domain.Answer;
import dk.howard.domain.Id;
import dk.howard.domain.Question;


public class CreateAnsweredQuestionDTO {

    private Id id;

    private final Question question;

    private final Answer answer;

    @JsonCreator
    public CreateAnsweredQuestionDTO(@JsonProperty("question") Question question, @JsonProperty("answer") Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Id getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "CreateAnsweredQuestionDTO{" +
                "id=" + id +
                ", questionPO=" + question +
                ", answerPO=" + answer +
                '}';
    }
}
