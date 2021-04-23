package dk.howard.resource;

import dk.howard.domain.*;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.*;

import javax.enterprise.context.Dependent;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Dependent
public class Mapper {



    CreateQuestionDTO mapCreateQuestion(Question question) {
        return new CreateQuestionDTO(
                question.getCategory(),
                question.getField(),
                question.getDescription(),
                question.getPoints(),
                new ArrayList<>(question.getAnswers()));
    }

    Question mapQuestion(CreateQuestionDTO createQuestionDTO) {
        return new Question(
                createQuestionDTO.getId(),
                createQuestionDTO.getCategory(),
                createQuestionDTO.getField(),
                createQuestionDTO.getDescription(),
                createQuestionDTO.getPoints(),
                createQuestionDTO.getAnswers()
        );
    }

    ReadQuestionDTO mapReadQuestion(Question question) {
        return new ReadQuestionDTO(
                question.getId(),
                question.getCategory(),
                question.getField(),
                question.getDescription(),
                question.getPoints(),
                question.getAnswers());
    }

    Answer mapCreateAnswer(CreateAnswerDTO createAnswerDTO) {
        return new Answer(
                createAnswerDTO.getId(),
                new AnswerName(createAnswerDTO.getAnswerName()),
                new Explanation(createAnswerDTO.getExplanation()),
                new TrueAnswer(createAnswerDTO.isTrueAnswer()),
                new Url(createAnswerDTO.getUrl()),
                new Question(
                        createAnswerDTO.getQuestion().getId(),
                        createAnswerDTO.getQuestion().getCategory(),
                        createAnswerDTO.getQuestion().getField(),
                        createAnswerDTO.getQuestion().getDescription(),
                        createAnswerDTO.getQuestion().getPoints()
                )
        );
    }
    AnsweredQuestion mapCreateAnsweredQuestion(CreateAnsweredQuestionDTO createAnsweredQuestionDTO) {
        Question newQuestion = createAnsweredQuestionDTO.getQuestion();
        Answer newAnswer = createAnsweredQuestionDTO.getAnswer();
        return new AnsweredQuestion(
                createAnsweredQuestionDTO.getId(),
                new Question(
                        newQuestion.getId(),
                        newQuestion.getCategory(),
                        newQuestion.getField(),
                        newQuestion.getDescription(),
                        newQuestion.getPoints()
                ),
                new Answer(
                        newAnswer.getId(),
                        newAnswer.getAnswerName(),
                        newAnswer.getExplanation(),
                        newAnswer.getTrueAnswer(),
                        newAnswer.getUrl(),
                        new Question(
                                newAnswer.getQuestion().getId(),
                                newAnswer.getQuestion().getCategory(),
                                newAnswer.getQuestion().getField(),
                                newAnswer.getQuestion().getDescription(),
                                newAnswer.getQuestion().getPoints()
                        ))
        );
    }

    ReadAnsweredQuestionDTO mapReadAnsweredQuestion(AnsweredQuestion answeredQuestion) {
        return new ReadAnsweredQuestionDTO(answeredQuestion.getId(), answeredQuestion.getQuestion(), answeredQuestion.getAnswer());
    }

    ReadAnswerDTO mapReadAnswer(Answer answer) {
        return new ReadAnswerDTO(
                answer.getId().getId().toString(),
                answer.getAnswerName().getAnswerName(),
                answer.getTrueAnswer().getTrueAnswer(),
                answer.getExplanation().getExplanation(),
                answer.getUrl().getUrl(),
                new Question(
                        answer.getQuestion().getId(),
                        answer.getQuestion().getCategory(),
                        answer.getQuestion().getField(),
                        answer.getQuestion().getDescription(),
                        answer.getQuestion().getPoints()
                )
        );
    }
    // Question
    List <ReadQuestionDTO> mapReadQuestions(List<Question> questions) {
        return questions.stream().map(q->mapReadQuestion(q)).collect(Collectors.toList());
    }

    // Answer
    List <ReadAnswerDTO> mapReadAnswers(List<Answer> answers) {
        return answers.stream().map(u->mapReadAnswer(u)).collect(Collectors.toList());
    }

    // Answered Question
    List <ReadAnsweredQuestionDTO> mapReadAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        return answeredQuestions.stream().map(u->mapReadAnsweredQuestion(u)).collect(Collectors.toList());
    }

}
