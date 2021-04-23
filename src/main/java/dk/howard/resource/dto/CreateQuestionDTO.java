package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.howard.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CreateQuestionDTO {

    private Id id;
    private Category category;
    private Field field;
    private Points points;
    private Description description;
    private List<Answer> answers;

    @JsonCreator
    public CreateQuestionDTO(@JsonProperty("category") Category category,
                             @JsonProperty("field") Field field,
                             @JsonProperty("description") Description description,
                             @JsonProperty("points") Points points,
                             @JsonProperty("answers") ArrayList<Answer> answers) {
        this.category = category;
        this.field = field;
        this.points = points;
        this.description = description;
        this.answers = answers;
    }

    public Id getId() {
        return id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Category getCategory() {
        return category;
    }

    public Field getField() {
        return field;
    }

    public Points getPoints() {
        return points;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CreateQuestionDTO{" +
                "id=" + id +
                ", category=" + category +
                ", field=" + field +
                ", points=" + points +
                ", description=" + description +
                ", answers=" + answers +
                '}';
    }
}
