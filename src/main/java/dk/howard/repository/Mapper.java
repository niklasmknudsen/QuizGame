package dk.howard.repository;

import dk.howard.domain.*;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.QuestionPO;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class Mapper {



    public Question mapQuestion(QuestionPO questionPO) {
        return new Question(
                new Id(questionPO.getId()),
                questionPO.getCategory(),
                new Field(questionPO.getField()),
                new Description(questionPO.getDescription()),
                new Points(questionPO.getPoints()),
                new ListAnswer().mapAnswers(questionPO.getAnswers()));
    }

    public QuestionPO mapQuestionPO(Question question) {
        return new QuestionPO(
                question.getCategory(),
                question.getField().toString(),
                question.getDescription().toString(),
                question.getPoints().getPoints());
    }

    public Answer mapAnswer(AnswerPO answerPO) {
        return new Answer(
                answerPO.getId(),


        );
    }

}
