package dk.howard.service.request;

import dk.howard.domain.Id;

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
