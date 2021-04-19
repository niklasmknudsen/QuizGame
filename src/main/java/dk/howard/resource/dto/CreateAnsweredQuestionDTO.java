package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.QuestionPO;


public class CreateAnsweredQuestionDTO {

    private final QuestionPO questionPO;

    private final AnswerPO answerPO;

    @JsonCreator
    public CreateAnsweredQuestionDTO(@JsonProperty("question") QuestionPO question, @JsonProperty("answer") AnswerPO answer) {
        this.questionPO = question;
        this.answerPO = answer;
    }

    public QuestionPO getQuestionPO() {
        return questionPO;
    }

    public AnswerPO getAnswerPO() {
        return answerPO;
    }


    @Override
    public String toString() {
        return "CreateAnsweredQuestionDTO{" +
                "questionPO=" + questionPO +
                ", answerPO=" + answerPO +
                '}';
    }
}
