package dk.QuizGame.service.request;

import dk.QuizGame.domain.Id;

public class AnsweredRequest {

    private Id questionID;
    private Id answerID;

    public AnsweredRequest(Id questionID, Id answerID) {
        this.questionID = questionID;
        this.answerID = answerID;
    }

    public Id getQuestionID() {
        return questionID;
    }

    public Id getAnswerID() {
        return answerID;
    }

    @Override
    public String toString() {
        return "AnsweredRequest{" +
                "questionID=" + questionID +
                ", answerID=" + answerID +
                '}';
    }
}
