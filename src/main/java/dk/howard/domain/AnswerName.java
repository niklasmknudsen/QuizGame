package dk.howard.domain;

import java.io.Serializable;

public class AnswerName implements Serializable {

    private final String answerName;

    public AnswerName(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerName() {
        return answerName;
    }

    @Override
    public String toString() {
        return "AnswerName{" +
                "answerName='" + answerName + '\'' +
                '}';
    }
}
