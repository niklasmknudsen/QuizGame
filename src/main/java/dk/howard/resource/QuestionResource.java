package dk.howard.resource;

import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateQuestionDTO;
import dk.howard.resource.dto.ReadQuestionDTO;
import dk.howard.service.QuestionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/question")
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
    public List<QuestionPO> getAll(){
        return questionService.getAllQuestions();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("")
    @POST
    public void createQuestion(CreateQuestionDTO createQuestionDTO){
        questionService.insert(mapper.mapQuestion(createQuestionDTO));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id")
    @DELETE
    public QuestionPO removeQuestion(@PathParam("id") String id){
        QuestionPO removedQuestion = questionService.remove(id);
        return removedQuestion;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id")
    @GET
    public ReadQuestionDTO getById(@PathParam("id") String id){
        ReadQuestionDTO selectedQuestion = mapper.mapReadQuestion(questionService.getById(id));
        return selectedQuestion;
    }
}
