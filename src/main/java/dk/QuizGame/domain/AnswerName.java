package dk.QuizGame.domain;

public class AnswerName {

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
