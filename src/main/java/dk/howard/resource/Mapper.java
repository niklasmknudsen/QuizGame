package dk.howard.resource;

import dk.howard.domain.Id;
import dk.howard.domain.Name;
import dk.howard.domain.User;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.*;

import javax.enterprise.context.Dependent;

@Dependent
public class Mapper {

    Id mapId(String id) {
        return new Id(id);
    }

    CreateQuestionDTO mapCreateQuestion(QuestionPO questionPO){
        return new CreateQuestionDTO(questionPO.getCategory(), questionPO.getField(), questionPO.getDescription(), questionPO.getPoints());
    }

    QuestionPO mapQuestion(CreateQuestionDTO createQuestionDTO){
        return new QuestionPO(createQuestionDTO.getCategory(), createQuestionDTO.getField(), createQuestionDTO.getDescription(), createQuestionDTO.getPoints());
    }

    ReadQuestionDTO mapReadQuestion(QuestionPO questionPO){
        return new ReadQuestionDTO(questionPO.getId(), questionPO.getCategory(), questionPO.getField(), questionPO.getDescription(), questionPO.getPoints());
    }

    AnswerPO mapCreateAnswer(CreateAnswerDTO createAnswerDTO) {
        return new AnswerPO(createAnswerDTO.getAnswerName(), createAnswerDTO.getQuestion(), createAnswerDTO.isTrueAnswer(), createAnswerDTO.getExplanation(), createAnswerDTO.getUrl());
    }

    ReadAnswerDTO mapReadAnswer(AnswerPO answerPO) {
        return new ReadAnswerDTO(answerPO.getId(), answerPO.getAnswerName(), answerPO.getQuestion(), answerPO.isTrueAnswer(), answerPO.getExplanation(), answerPO.getUrl());
    }

    AnsweredQuestionPO mapCreateAnsweredQuestion(CreateAnsweredQuestionDTO createAnsweredQuestionDTO) {
        return new AnsweredQuestionPO(createAnsweredQuestionDTO.getQuestionPO(), createAnsweredQuestionDTO.getAnswerPO());
    }

    ReadAnsweredQuestionDTO mapReadAnsweredQuestion(AnsweredQuestionPO answeredQuestionPO) {
        return new ReadAnsweredQuestionDTO(answeredQuestionPO.getQuestionPO(), answeredQuestionPO.getAnswerPO());
    }

}
