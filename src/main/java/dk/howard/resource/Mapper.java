package dk.howard.resource;

import dk.howard.domain.Id;
import dk.howard.domain.Name;
import dk.howard.domain.User;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateQuestionDTO;
import dk.howard.resource.dto.ReadQuestionDTO;
import dk.howard.resource.dto.UserDTO;

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
}
