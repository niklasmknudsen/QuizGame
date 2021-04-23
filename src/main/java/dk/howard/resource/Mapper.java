package dk.howard.resource;

import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.*;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Dependent
public class Mapper {

    CreateQuestionDTO mapCreateQuestion(QuestionPO questionPO) {
        return new CreateQuestionDTO(questionPO.getCategory(), questionPO.getField(), questionPO.getDescription(), questionPO.getPoints());
    }

    QuestionPO mapQuestion(CreateQuestionDTO createQuestionDTO) {
        return new QuestionPO(createQuestionDTO.getCategory(), createQuestionDTO.getField(), createQuestionDTO.getDescription(), createQuestionDTO.getPoints());
    }

    ReadQuestionDTO mapReadQuestion(QuestionPO questionPO) {
        return new ReadQuestionDTO(questionPO.getId(), questionPO.getCategory(), questionPO.getField(), questionPO.getDescription(), questionPO.getPoints(), questionPO.getAnswers());
    }

    AnswerPO mapCreateAnswer(CreateAnswerDTO createAnswerDTO) {
        return new AnswerPO(createAnswerDTO.getAnswerName(), createAnswerDTO.isTrueAnswer(), createAnswerDTO.getExplanation(), createAnswerDTO.getUrl(), createAnswerDTO.getQuestion());
    }

    ReadAnswerDTO mapReadAnswer(AnswerPO answerPO) {
        return new ReadAnswerDTO(answerPO.getId(), answerPO.getAnswerName(), answerPO.isTrueAnswer(), answerPO.getExplanation(), answerPO.getUrl(), answerPO.getQuestion());
    }

    AnsweredQuestionPO mapCreateAnsweredQuestion(CreateAnsweredQuestionDTO createAnsweredQuestionDTO) {
        return new AnsweredQuestionPO(createAnsweredQuestionDTO.getQuestionPO(), createAnsweredQuestionDTO.getAnswerPO());
    }

    ReadAnsweredQuestionDTO mapReadAnsweredQuestion(AnsweredQuestionPO answeredQuestionPO) {
        return new ReadAnsweredQuestionDTO(answeredQuestionPO.getQuestionPO(), answeredQuestionPO.getAnswerPO());
    }

    // Answer
    List <AnswerPO> mapAnswer(List<AnswerPO> answers) {
        return answers.stream().map(u->mapAnswer(u)).collect(Collectors.toList());
    }

    AnswerPO mapAnswer(AnswerPO answerPO) {
        return new AnswerPO(answerPO.getAnswerName(),
                answerPO.isTrueAnswer(), answerPO.getExplanation(), answerPO.getUrl(), answerPO.getQuestion());
    }
    // Question
    List <QuestionPO> mapQuestion(List<QuestionPO> questionPO) {
        return questionPO.stream().map(u->mapQuestion(u)).collect(Collectors.toList());
    }

    QuestionPO mapQuestion(QuestionPO questionPO) {
        return new QuestionPO(questionPO.getCategory(), questionPO.getField(),
                questionPO.getDescription(), questionPO.getPoints());
    }
    // Answered Question
    List <AnsweredQuestionPO> mapAnsweredQuestion(List<AnsweredQuestionPO> answeredQuestionPO) {
        return answeredQuestionPO.stream().map(u->mapAnsweredQuestion(u)).collect(Collectors.toList());
    }

    AnsweredQuestionPO mapAnsweredQuestion(AnsweredQuestionPO answeredQuestionPO) {
        return new AnsweredQuestionPO(answeredQuestionPO.getQuestionPO(),
                answeredQuestionPO.getAnswerPO());
    }


}
