package dk.howard.domain;

import java.util.List;

public class Question {

    private final Category category;
    private final String field;
    private final String description;
    private final int points;
    private final List<Answer> answers;
    private final Id id;

    public Question(Id id, Category category, String field, String description, int points, List<Answer> answers) {
        this.category = category;
        this.field = field;
        this.description = description;
        this.points = points;
        this.answers = answers;
        this.id = id;
    }

    public Id getId() {
        return id;
    }

    public Category getCategory() {
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

    public List<Answer> getAnswers() {
        return answers;
    }
}
