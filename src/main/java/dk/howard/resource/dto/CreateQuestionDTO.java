package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CreateQuestionDTO {

    private String category;
    private String field;
    private int points;
    private String description;
    private List<CreateAnswerDTO> answers;

    @JsonCreator
    public CreateQuestionDTO(@JsonProperty("category") String category,
                             @JsonProperty("field") String field,
                             @JsonProperty("description") String description,
                             @JsonProperty("points") int points,
                             @JsonProperty("answers") ArrayList<CreateAnswerDTO> answers) {
        this.category = category;
        this.field = field;
        this.points = points;
        this.description = description;
        this.answers = answers;
    }

    public List<CreateAnswerDTO> getAnswers() {
        return answers;
    }

    public String getCategory() {
        return category;
    }

    public String getField() {
        return field;
    }

    public int getPoints() {
        return points;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CreateQuestionDTO{" +
                ", category=" + category +
                ", field=" + field +
                ", points=" + points +
                ", description=" + description +
                ", answers=" + answers +
                '}';
    }
}
