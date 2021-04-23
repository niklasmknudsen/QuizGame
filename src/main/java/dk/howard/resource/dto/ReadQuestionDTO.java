package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dk.howard.domain.*;
import java.util.ArrayList;
import java.util.List;

public class ReadQuestionDTO {

    private Id id;

    private Category category;

    private Field field;

    private Description description;

    private Points points;

    @JsonBackReference
    private List<Answer> answers = new ArrayList<>();

    public ReadQuestionDTO(){ }

    public ReadQuestionDTO(Id id, Category category, Field field, Description description, Points points, List<Answer> answers) {
        this.id = id;
        this.category = category;
        this.field = field;
        this.description = description;
        this.points = points;
        this.answers = answers;
    }

    public Id getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Field getField() {
        return field;
    }

    public Description getDescription() {
        return description;
    }

    public Points getPoints() {
        return points;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "ReadQuestionDTO{" +
                "id=" + id +
                ", category=" + category +
                ", field=" + field +
                ", description=" + description +
                ", points=" + points +
                ", answers=" + answers +
                '}';
    }
}
