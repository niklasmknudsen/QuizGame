package dk.QuizGame.repository;

import dk.QuizGame.domain.*;
import dk.QuizGame.repository.entity.AnswerPO;
import dk.QuizGame.repository.entity.QuestionPO;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Mapper {

    // Answer
    public List<Answer> mapAnswers(List<AnswerPO> answers) {
        return answers.stream().map(a->mapAnswer(a)).collect(Collectors.toList());
    }

    // Question
    public List<Question> mapQuestions(List<QuestionPO> questions) {
        return questions.stream().map(q->mapQuestion(q)).collect(Collectors.toList());
    }

    public Question mapQuestion(QuestionPO questionPO) {
        return new Question(
                new Id(questionPO.getId()),
                questionPO.getCategory(),
                new Field(questionPO.getField()),
                new Description(questionPO.getDescription()),
                new Points(questionPO.getPoints()),
                mapAnswers(questionPO.getAnswers()));
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
                new Id(answerPO.getId().toString()),
                new AnswerName(answerPO.getAnswerName()),
                new Explanation(answerPO.getExplanation()),
                answerPO.isTrueAnswer(),
                new Url(answerPO.getUrl())
        );
    }

    public List<Answer> mapAnswer(List<AnswerPO> answers) {
        return answers.stream().map(this::mapAnswer).collect(Collectors.toList());
    }

    public AnswerPO mapAnswerPO(Answer answer) {
        return new AnswerPO(
                answer.getAnswerName().getAnswerName(),
                answer.getTrueAnswer(),
                answer.getExplanation().getExplanation(),
                answer.getUrl().getUrl()
        );
    }

    public List<AnswerPO> mapAnswerPO(List<Answer> answers) {
        return answers.stream().map(this::mapAnswerPO).collect(Collectors.toList());
    }
}
