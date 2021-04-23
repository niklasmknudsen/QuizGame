package dk.howard.domain;

import dk.howard.repository.entity.AnswerPO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListAnswer implements Serializable {

    private final List<Answer> answers = new ArrayList<>();

    /***
     * Maps list of answerPO objects to a list of answers
     * @param answersToMap
     * @return
     */
    public List<Answer> mapAnswers(List<AnswerPO> answersToMap) {
        for (AnswerPO answer : answersToMap) {
            Answer convertedAnswer = new Answer(
                    new Id(answer.getId().toString()),
                    new AnswerName(answer.getAnswerName()),
                    new Explanation(answer.getExplanation()),
                    new TrueAnswer(answer.isTrueAnswer()),
                    new Url(answer.getUrl()),
                    new Question(
                            new Id(answer.getId().toString()),
                            answer.getQuestion().getCategory(),
                            new Field(answer.getQuestion().getField()),
                            new Description(answer.getQuestion().getDescription()),
                            new Points(answer.getQuestion().getPoints())
                        )
                    );
            this.answers.add(convertedAnswer);
        }
        return answers;
    }
}
