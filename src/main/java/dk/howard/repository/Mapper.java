package dk.howard.repository;

import dk.howard.domain.*;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import dk.howard.repository.entity.QuestionPO;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
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

    // AnsweredQuestion
    public List<AnsweredQuestion> mapAnsweredQuestions(List<AnsweredQuestionPO> answeredQuestionPOS) {
        return answeredQuestionPOS.stream().map(aq -> mapAnsweredQuestion(aq)).collect(Collectors.toList());
    }

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
                new Id(answerPO.getId().toString()),
                new AnswerName(answerPO.getAnswerName()),
                new Explanation(answerPO.getExplanation()),
                new TrueAnswer(answerPO.isTrueAnswer()),
                new Url(answerPO.getUrl()),
                new Question(
                        new Id(answerPO.getQuestion().getId()),
                        answerPO.getQuestion().getCategory(),
                        new Field(answerPO.getQuestion().getField()),
                        new Description(answerPO.getQuestion().getDescription()),
                        new Points(answerPO.getQuestion().getPoints())
                )

        );
    }

    public AnswerPO mapAnswerPO(Answer answer) {
        return new AnswerPO(
                answer.getAnswerName().getAnswerName(),
                answer.getTrueAnswer().getTrueAnswer(),
                answer.getExplanation().getExplanation(),
                answer.getUrl().getUrl(),
                new QuestionPO(
                        answer.getQuestion().getCategory(),
                        answer.getQuestion().getField().toString(),
                        answer.getQuestion().getDescription().toString(),
                        answer.getQuestion().getPoints().getPoints())
        );
    }

    public AnsweredQuestion mapAnsweredQuestion(AnsweredQuestionPO answeredQuestionPO) {
        return new AnsweredQuestion(
            new Id(answeredQuestionPO.getId().toString()),
            new Question(
              new Id(answeredQuestionPO.getQuestionPO().getId()),
              answeredQuestionPO.getQuestionPO().getCategory(),
              new Field(answeredQuestionPO.getQuestionPO().getField()),
              new Description(answeredQuestionPO.getQuestionPO().getDescription()),
              new Points(answeredQuestionPO.getQuestionPO().getPoints())
            ),
            new Answer(
                    new Id(answeredQuestionPO.getAnswerPO().getId().toString()),
                    new AnswerName(answeredQuestionPO.getAnswerPO().getAnswerName()),
                    new Explanation(answeredQuestionPO.getAnswerPO().getExplanation()),
                    new TrueAnswer(answeredQuestionPO.getAnswerPO().isTrueAnswer()),
                    new Url(answeredQuestionPO.getAnswerPO().getUrl()),
                    new Question(
                            new Id(answeredQuestionPO.getQuestionPO().getId()),
                            answeredQuestionPO.getQuestionPO().getCategory(),
                            new Field(answeredQuestionPO.getQuestionPO().getField()),
                            new Description(answeredQuestionPO.getQuestionPO().getDescription()),
                            new Points(answeredQuestionPO.getQuestionPO().getPoints())
                    )
            )
        );
    }

    public AnsweredQuestionPO mapAnsweredQuestionPO(AnsweredQuestion answeredQuestion) {
        return new AnsweredQuestionPO(
                new QuestionPO(
                        answeredQuestion.getQuestion().getCategory(),
                        answeredQuestion.getQuestion().getField().getField(),
                        answeredQuestion.getQuestion().getDescription().getDescription(),
                        answeredQuestion.getQuestion().getPoints().getPoints()
                ),
                new AnswerPO(
                        answeredQuestion.getAnswer().getAnswerName().getAnswerName(),
                        answeredQuestion.getAnswer().getTrueAnswer().getTrueAnswer(),
                        answeredQuestion.getAnswer().getExplanation().getExplanation(),
                        answeredQuestion.getAnswer().getUrl().getUrl(),
                        new QuestionPO(
                                answeredQuestion.getAnswer().getQuestion().getCategory(),
                                answeredQuestion.getAnswer().getQuestion().getField().getField(),
                                answeredQuestion.getAnswer().getQuestion().getDescription().getDescription(),
                                answeredQuestion.getAnswer().getQuestion().getPoints().getPoints()
                        )
                )

        );
    }
}
