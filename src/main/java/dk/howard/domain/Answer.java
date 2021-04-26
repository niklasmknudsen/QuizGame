package dk.howard.domain;

public class Answer{


    private final Id id;

    private final AnswerName answerName;

    private final Explanation explanation;

    private final boolean trueAnswer;

    private final Url url;


    public Answer(Id id, AnswerName answerName, Explanation explanation, boolean trueAnswer, Url url) {
        this.id = id;
        this.answerName = answerName;
        this.explanation = explanation;
        this.trueAnswer = trueAnswer;
        this.url = url;
    }
    public Answer(AnswerName answerName, Explanation explanation, boolean trueAnswer, Url url) {
        this.id = null;
        this.answerName = answerName;
        this.explanation = explanation;
        this.trueAnswer = trueAnswer;
        this.url = url;
    }

    public Id getId() {
        return id;
    }

    public AnswerName getAnswerName() {
        return answerName;
    }

    public Explanation getExplanation() {
        return explanation;
    }

    public boolean getTrueAnswer() {
        return trueAnswer;
    }

    public Url getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerName=" + answerName +
                ", explanation=" + explanation +
                ", trueAnswer=" + trueAnswer +
                ", url=" + url +
                '}';
    }
}
