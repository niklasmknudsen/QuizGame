package dk.howard.domain;

public class TrueAnswer {

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
