package dk.howard.domain;

import java.io.Serializable;

public class Answer implements Serializable {


    private final Id id;

    private final AnswerName answerName;

    private final Explanation explanation;

    private final TrueAnswer trueAnswer;

    private final Url url;

    private final Question question;


    public Answer(Id id, AnswerName answerName, Explanation explanation, TrueAnswer trueAnswer, Url url, Question question) {
        this.id = id;
        this.answerName = answerName;
        this.explanation = explanation;
        this.trueAnswer = trueAnswer;
        this.url = url;
        this.question = question;
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

    public TrueAnswer getTrueAnswer() {
        return trueAnswer;
    }

    public Url getUrl() {
        return url;
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerName=" + answerName +
                ", explanation=" + explanation +
                ", trueAnswer=" + trueAnswer +
                ", url=" + url +
                ", question=" + question +
                '}';
    }
}
