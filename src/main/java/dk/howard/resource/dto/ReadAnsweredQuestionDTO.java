package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.domain.Answer;
import dk.howard.domain.Id;
import dk.howard.domain.Question;

public class ReadAnsweredQuestionDTO {

    private final Id id;

    private final Question question;

    private final Answer answer;

    public ReadAnsweredQuestionDTO(Id id, Question question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Id getId() {
        return id;
    }

    public Question getQuestionPO() {
        return question;
    }

    public Answer getAnswerPO() {
        return answer;
    }


    @Override
    public String toString() {
        return "ReadAnsweredQuestionDTO{" +
                "id=" + id +
                ", questionPO=" + question +
                ", answerPO=" + answer +
                '}';
    }
}
