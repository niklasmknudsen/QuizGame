package dk.howard.domain;

import dk.howard.repository.entity.QuestionPO;

public class AnsweredQuestion {

    private final Id id;

    private final Question question;

    private final Answer answer;

    public AnsweredQuestion(Id id, Question question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Id getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "AnsweredQuestion{" +
                "id=" + id +
                ", question=" + question +
                ", answer=" + answer +
                '}';
    }
}
