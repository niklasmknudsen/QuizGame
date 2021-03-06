package dk.QuizGame.resource;

import dk.QuizGame.domain.Id;
import dk.QuizGame.resource.dto.CreateAnswerDTO;
import dk.QuizGame.resource.dto.ReadAnswerDTO;
import dk.QuizGame.service.AnswerService;

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
    public List<ReadAnswerDTO> getAll(){
        try {
            return mapper.mapReadAnswers(service.getAll());
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
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
    public void removeAnswer(@PathParam("id") Id id){
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
    public ReadAnswerDTO getById(@PathParam("id") Id id){
        if (id != null) {
            ReadAnswerDTO selectedAnswer = mapper.mapReadAnswer(service.getById(id));
            return selectedAnswer;
        }
        return null;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/question/{id}")
    @GET
    public List<ReadAnswerDTO> getByQId(@PathParam("qid") Id id) {
        if (id != null) {
            List<ReadAnswerDTO> selectedAnswers = mapper.mapReadAnswers(service.getByQId(id));
            return selectedAnswers;
        }
        return null;
    }


}
