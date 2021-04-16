package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateQuestionDTO {

    private String category;
    private String field;
    private int points;
    private String description;

    @JsonCreator
    public CreateQuestionDTO(@JsonProperty("category") String category,
                             @JsonProperty("field") String field,
                             @JsonProperty("description") String description,
                             @JsonProperty("points") int points) {
        this.category = category;
        this.field = field;
        this.points = points;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CreateQuestionDTO{" +
                "category='" + category + '\'' +
                ", field='" + field + '\'' +
                ", points=" + points +
                ", description='" + description + '\'' +
                '}';
    }
}
