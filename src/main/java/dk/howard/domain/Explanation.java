package dk.howard.domain;

import java.io.Serializable;

public class Explanation implements Serializable {

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
