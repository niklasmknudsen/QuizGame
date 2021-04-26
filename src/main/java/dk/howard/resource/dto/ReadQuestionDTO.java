package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dk.howard.domain.*;
import java.util.ArrayList;
import java.util.List;

public class ReadQuestionDTO {

    private String id;

    private String category;

    private String field;

    private String description;

    private int points;

    private List<AnswerDTO> answers;

    public ReadQuestionDTO(){ }

    public ReadQuestionDTO(String id, String category, String field, String description, int points, List<AnswerDTO> answers) {
        this.id = id;
        this.category = category;
        this.field = field;
        this.description = description;
        this.points = points;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getField() {
        return field;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    public List<AnswerDTO> getAnswers() {
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
