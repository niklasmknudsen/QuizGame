package dk.howard.resource;

import dk.howard.domain.*;
import dk.howard.resource.dto.*;
import dk.howard.service.request.AnsweredRequest;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
class Mapper {


    Category mapCategory (String category) {
        return Category.valueOf(category);
    }

    Field mapField (String field) {
        return new Field(field);
    }

    Description mapDescription (String description) {
        return new Description(description);
    }

    Points mapPoints (int points) {
        return new Points(points);
    }

    Question mapQuestion(CreateQuestionDTO createQuestionDTO) {
        return new Question(
                mapCategory(createQuestionDTO.getCategory()),
                mapField(createQuestionDTO.getField()),
                mapDescription(createQuestionDTO.getDescription()),
                mapPoints(createQuestionDTO.getPoints()),
                mapCreateAnswer(createQuestionDTO.getAnswers())
        );
    }

    AnswerDTO mapAnswerDTO(Answer answer) {
        return new AnswerDTO(answer.getId().getId().toString(),
                answer.getAnswerName().getAnswerName());
    }

    List<AnswerDTO> mapAnswerDTO(List<Answer> answers) {
        return answers.stream().map(this::mapAnswerDTO).collect(Collectors.toList());
    }

    ReadQuestionDTO mapReadQuestion(Question question) {
        return new ReadQuestionDTO(
                question.getId().getId().toString(),
                question.getCategory().name(),
                question.getField().getField(),
                question.getDescription().getDescription(),
                question.getPoints().getPoints(),
                mapAnswerDTO(question.getAnswers()));
    }

    AnswerName mapAnswerName (String answerName) {
        return new AnswerName(answerName);
    }
    Explanation mapExplanation (String explanation) {
        return new Explanation(explanation);
    }
    Url mapUrl (String url) {
        return new Url(url);
    }

    Answer mapCreateAnswer(CreateAnswerDTO createAnswerDTO) {
        return new Answer(
                mapAnswerName(createAnswerDTO.getAnswerName()),
                mapExplanation(createAnswerDTO.getExplanation()),
                createAnswerDTO.isTrueAnswer(),
                mapUrl(createAnswerDTO.getUrl())
        );
    }
    List<Answer> mapCreateAnswer(List<CreateAnswerDTO> createAnswerDTOs) {
        return createAnswerDTOs.stream().map(this::mapCreateAnswer).collect(Collectors.toList());
    }

    Id mapId(String id) {
        return new Id(id);
    }

    AnsweredRequest mapCreateAnsweredQuestion(String questionID,CreateAnsweredQuestionDTO createAnsweredQuestionDTO) {
        return new AnsweredRequest(mapId(questionID),mapId(createAnsweredQuestionDTO.getAnswer()));
    }

    ReadAnswerDTO mapReadAnswer(Answer answer) {
        return new ReadAnswerDTO(
                answer.getId().getId().toString(),
                answer.getAnswerName().getAnswerName(),
                answer.getTrueAnswer(),
                answer.getExplanation().getExplanation(),
                answer.getUrl().getUrl()
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

}
