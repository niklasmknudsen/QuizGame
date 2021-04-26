package dk.howard.resource.dto;

public class AnswerDTO {

    private final String id;

    private final String answerName;

    public AnswerDTO(String id, String answerName) {
        this.id = id;
        this.answerName = answerName;
    }

    public String getId() {
        return id;
    }

    public String getAnswerName() {
        return answerName;
    }
}
