package dk.howard.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {

    private final Id id;
    private final Category category;
    private final Field field;
    private final Description description;
    private final Points points;
    private final List<Answer> answers;

    public Question(Id id,Category category, Field field, Description description, Points points) {
        this.id = id;
        this.category = category;
        this.field = field;
        this.description = description;
        this.points = points;
        this.answers = new ArrayList<>();
    }

    public Question(Id id, Category category, Field field, Description description, Points points, List<Answer> answers) {
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
        return "Question{" +
                "id=" + id +
                ", category=" + category +
                ", field=" + field +
                ", description=" + description +
                ", points=" + points +
                ", answers=" + answers +
                '}';
    }
}
