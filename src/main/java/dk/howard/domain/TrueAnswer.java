package dk.howard.domain;

import java.io.Serializable;

public class TrueAnswer implements Serializable {

    private final boolean trueAnswer;

    public TrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public boolean getTrueAnswer() {
        return trueAnswer;
    }

    @Override
    public String toString() {
        return "TrueAnswer{" +
                "trueAnswer='" + trueAnswer + '\'' +
                '}';
    }
}
