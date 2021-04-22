package dk.howard.resource;

import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.QuestionPO;
import dk.howard.resource.dto.CreateAnswerDTO;
import dk.howard.resource.dto.CreateQuestionDTO;
import dk.howard.resource.dto.ReadAnswerDTO;
import dk.howard.resource.dto.ReadQuestionDTO;
import dk.howard.service.AnswerService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
// localhost:port/answer/
@Path("/answer")
@RequestScoped
public class AnswerResource {

    private final AnswerService service;
    private final Mapper mapper;

    @Inject
    public AnswerResource(AnswerService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    @GET
    public List<AnswerPO> getAll(){
        return service.getAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("")
    @POST
    public void createAnswer(CreateAnswerDTO createAnswerDTO){
        try {
            service.insert(mapper.mapCreateAnswer(createAnswerDTO));
        } catch (NoResultException exception) {
            throw new NoResultException(exception.getMessage());
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @DELETE
    public void removeAnswer(@PathParam("id") int id){
        try {
            service.remove(id);
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public ReadAnswerDTO getById(@PathParam("id") int id){
        if (id != 0) {
            ReadAnswerDTO selectedAnswer = mapper.mapReadAnswer(service.getById(id));
            return selectedAnswer;
        }
        return null;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/question/{id}")
    @GET
    public List<AnswerPO> getByQId(@PathParam("qid") int id) {
        if (id != 0) {
            List<AnswerPO> selectedAnswers = mapper.mapAnswer(service.getByQId(id));
            return selectedAnswers;
        }
        return null;
    }


}
