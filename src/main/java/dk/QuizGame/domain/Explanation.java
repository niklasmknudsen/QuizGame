package dk.QuizGame.domain;

public class Explanation {

    private final String explanation;

    public Explanation(String explanation) {
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "explanation='" + explanation + '\'' +
                '}';
    }
}
