package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ReadQuestionDTO {

    private int id;

    private String category;

    private String field;

    private String description;

    private int points;

    private AnsweredQuestionPO answeredQuestionPO;

    @JsonBackReference
    private List<AnswerPO> answers = new ArrayList<AnswerPO>();

    public ReadQuestionDTO(){
        this.answeredQuestionPO = null;
    }

    public ReadQuestionDTO(int id, String category, String field, String description, int points){
        this.id = id;
        this.category = category;
        this.field = field;
        this.description = description;
        this.points = points;
    }

    public List<AnswerPO> getAnswers(){
        return answers;
    }

    public void setAnswers (List<AnswerPO> answers){
        this.answers = answers;
    }

    public AnsweredQuestionPO getAnsweredQuestion(){
        return this.answeredQuestionPO;
    }

    public void setAnsweredQuestionPO(AnsweredQuestionPO answeredQuestionPO){
        this.answeredQuestionPO = answeredQuestionPO;
    }

    @Override
    public String toString() {
        return "ReadQuestionDTO{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", field='" + field + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", answeredQuestionPO=" + answeredQuestionPO +
                ", answers=" + answers +
                '}';
    }
}
