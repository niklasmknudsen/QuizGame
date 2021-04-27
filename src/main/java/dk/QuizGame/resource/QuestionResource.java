package dk.QuizGame.resource;

import dk.QuizGame.domain.Id;
import dk.QuizGame.resource.dto.CreateAnsweredQuestionDTO;
import dk.QuizGame.resource.dto.CreateQuestionDTO;
import dk.QuizGame.resource.dto.ReadAnswerDTO;
import dk.QuizGame.resource.dto.ReadQuestionDTO;
import dk.QuizGame.service.QuestionService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/question")
@RequestScoped
public class QuestionResource {
    private final QuestionService questionService;
    private final Mapper mapper;

    @Inject
    public QuestionResource(QuestionService questionService, Mapper mapper){
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    @GET
    public List<ReadQuestionDTO> getAll() {
       try {
           return mapper.mapReadQuestions(questionService.getAllQuestions());
       } catch (NoResultException e) {
           throw new NoResultException(e.getMessage());
       }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/answer")
    @POST
    public ReadAnswerDTO answerQuestion(@PathParam("id") String questionId,CreateAnsweredQuestionDTO createAnsweredQuestionDTO){
        return mapper.mapReadAnswer(questionService.receiveAnswer(
                mapper.mapCreateAnsweredQuestion(
                        questionId,
                        createAnsweredQuestionDTO)));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("")
    @POST
    public void createQuestion(CreateQuestionDTO createQuestionDTO){
        questionService.insert(mapper.mapQuestion(createQuestionDTO));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @DELETE
    public void removeQuestion(@PathParam("id") Id id){
        try {
            questionService.remove(id);
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public ReadQuestionDTO getById(@PathParam("id") Id id){
        ReadQuestionDTO selectedQuestion = mapper.mapReadQuestion(questionService.getById(id));
        return selectedQuestion;
    }
}
